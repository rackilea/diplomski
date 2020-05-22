# Use a hashtable for O(1) lookup for a node by name
$Script:NodeTracker = @{}
class TaskNode {
    #==PROPS==================================================|
    [System.Collections.ArrayList]$then = @()
    [String] $Val
    [Bool]$Visited = $false
    [Collections.ArrayList]$Parent = @()
    #==CONSTRUCTORS===========================================|
    TaskNode([String]$Val) {$this.constructor($Val, $null)}
    TaskNode([String]$Val, [TaskNode]$Parent) {$this.constructor($Val, $Parent)}
    hidden constructor([String]$Val, [TaskNode]$Parent) {
        $This.Val = $Val
        if ($Parent) {$This.Parents.Add($Parent)}
        $Script:NodeTracker.$Val = $This
    }

    #==METHODS================================================|
    [TaskNode] To([String]$Val) {
        $Node = $Script:NodeTracker.$Val

        # If node doesn't exist, create and track
        if (!$Node) {$Node = New-Object TaskNode $Val}
        $This.then.Add($Node)
        $Node.Parent.Add($This)
        return $Node
    }
    [String] ToString() {return "$($this.val)-$(if($this.Visited){'✓'}else{'✘'})"}
    static [String] ReverseModdedBFS([Collections.Queue]$Queue) {
        $Output = ""
        [Collections.Queue]$NextQueue = @()
        do {
            while ($Queue.Count) {
                $Root = $Queue.Dequeue()
                # Write-Host "Root: $Root | Queue: [$Queue] | Next-Queue [$NextQueue] | Non-Visited [$($Root.then | {!$_.Visited})]"
                if ($Root.Visited) {continue}
                if ($Root.Then.Count -gt 1 -and ($Root.then | {!$_.Visited})) {$NextQueue.Enqueue($Root);continue}
                $Root.Visited = $true
                $Output += ','+$Root.Val
                $Root.Parent | % {
                    # Write-Host "    Enqueuing $_"
                    $Queue.Enqueue($_)
                }
            }
            If ($Queue.Count -eq 1 -and !$Queue.Peek().Parent.count) {break}
            $Queue = $NextQueue
            $NextQueue = @()
        } while($Queue.Count)
        $Out = $Output.Substring(1).split(',')
        [Array]::Reverse($Out)
        return $Out -join ','
    }
    #==STATICS=================================================|
    static [TaskNode] Fetch([String]$Val) {
        $Node = $Script:NodeTracker.$Val
        # If node doesn't exist, create and track
        if (!$Node) {return (New-Object TaskNode $Val)}
        return $Node
    }
    static [TaskNode[]] GetAll() {
        return @($Script:NodeTracker.Values)
    }
    static [TaskNode] GetStart() {
        $Nodes = [TaskNode]::GetAll() | {$_.Parent.count -eq 0}
        if ($Nodes.Count -gt 1) {throw 'There is more than one starting node!'}
        if (!$Nodes.Count) {throw 'There is no starting node!'}
        return @($Nodes)[0]
    }
    static [TaskNode[]] GetEnds() {
        $Nodes = [TaskNode]::GetAll() | {$_.Then.count -eq 0}
        if (!$Nodes.Count) {throw 'There is no ending node!'}
        return @($Nodes)
    }
}

function Parse-Edge($From, $To) {
    # Use the safe static accessor so that it will fetch the singleton instance of the node, or create and return one!
    [TaskNode]::Fetch($From).To($To)
}

function XML-Main([xml]$XML) {
    @($XML.Flow.Task) | % {Parse-Edge $_.From $_.To}
    [TaskNode]::ReverseModdedBFS([TaskNode]::GetEnds())
}