[Code]
{ Script to check if a JRE is installed }

function InitializeSetup(): Boolean;
var
  ErrorCode: Integer;
  JavaVer: string;
begin
    RegQueryStringValue(
        HKLM, 'SOFTWARE\JavaSoft\Java Runtime Environment', 'CurrentVersion', JavaVer);
    Result := (Length(JavaVer) > 0);
    if not Result then
    begin
        if MsgBox('YOUR MESSAGE GOES HERE', mbConfirmation, MB_YESNO) = idYes then
        begin
            ShellExec(
              'open', 'https://www.java.com/en/download/manual.jsp#win',
              '', '', SW_SHOWNORMAL, ewNoWait, ErrorCode);
        end;
    end;
end;