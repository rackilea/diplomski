$timeoutSec = 10;
$lookingSec = 0;
While $lookingSec < $timeoutSec
    ;Firefox or InternetExplorer or Chrome
    If WinExists("[CLASS:MozillaDialogClass]") _
        Or WinExists("[TITLE:Windows Security; CLASS:#32770]") _
            Or WinExists("[CLASS:Chrome_WidgetWin_1]", _
                                    "Authentication Required") Then
                ;user name
                Send($CmdLine[1] & "{TAB}"); 
                ;password
                Send($CmdLine[2] & "{ENTER}"); 
                Exit;
    EndIf
    sleep(1000)
    $lookingSec += 1;
WEnd