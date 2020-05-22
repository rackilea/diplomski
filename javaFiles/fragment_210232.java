foreach ($server in $servers) {

        $Keys = Get-ChildItem HKLM:\System\CurrentControlSet\services -Recurse -Include "Parameters" -EA SilentlyContinue
        $Items = $Keys | Foreach-Object {Get-ItemProperty $_.PsPath }
        ForEach ($Item in $Items) {
        $Item.ServiceExe
        }

        if($Item.ServiceExe -like "*jre6*", "*jre1.6*", "*jre1.7*", "*jre7*", "*jdk1.6*", "*jdk1.7*") {
            write-host "Cannot continue, old Java is in use"
        } else {
            write-host "Verified old Java is not in use, continuing..."
            findJava -servers $servers}
        }