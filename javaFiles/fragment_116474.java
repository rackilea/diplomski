Import-Module ActiveDirectory
$badcomp = @()

Function uninstallJava {
    $CompList = Get-ADComputer -Filter 'name -like "*"' | Select -ExpandProperty Name
    ForEach ($c In $CompList) {
        Try {
            Invoke-Command -ComputerName $c {
                C:\Windows\System32\cmd.exe /C msiexec.exe /q /x '{26A24AE4-039D-4CA4-87B4-2F83218025F0}'
            }
        } Catch {
            $badcomp += $c
        }
    }
}
uninstallJava

Write-Host "the following servers could not be reached:"
$badcomp