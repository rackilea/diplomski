$Matches = @()
    $String = 'key1(value1) key2(value2)
key3(value3) key3.5
key4 key5(value5)  GoofyStuff(I like kittens)
key6 key7 ForReal-Things(be sure to vote)
key8'
    Write-Host start with 
    write-host $String
    Write-Host
    Write-Host found
    ([regex]'(?<=^|[\s)\n])([^(\n\s]*)([(]([^)\n]*)[)])?').matches($String) | foreach {
        if ($_.Groups[1].Value) {
            write-host "key at $($_.Groups[1].Index) = '$($_.Groups[1].Value)'"
            if ($_.Groups[3].Value) {
                write-host "value at $($_.Groups[3].Index) = '$($_.Groups[3].Value)'"
                } # end if
            } # end if
        } # next match