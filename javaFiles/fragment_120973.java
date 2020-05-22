$ESCkey  = 27
Write-Host "Press the ESC key to stop sniffing" -foregroundcolor "CYAN"
$Running=$true

While ($Running)
    { 
         if ($host.ui.RawUi.KeyAvailable) {
         $key = $host.ui.RawUI.ReadKey("NoEcho,IncludeKeyUp,IncludeKeyDown")
            if ($key.VirtualKeyCode -eq $ESCkey) { 
             $Running=$False
            }
         #rest of function here 
        }