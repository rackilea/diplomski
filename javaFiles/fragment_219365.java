!include LogicLib.nsh
showinstdetails show
section

System::Get "(i.r1) iss"
Pop $R0
System::Call "user32::EnumWindows(k R0,i) i.s"
loop:
    Pop $0
    StrCmp $0 "callback1" 0 done
    System::Call "user32::IsWindowVisible(ir1)i.r2"
    ${If} $2 <> 0
        System::Call "user32::GetWindowText(ir1,t.r2,i${NSIS_MAX_STRLEN})"
        System::Call "user32::GetClassName(ir1,t.r3,i${NSIS_MAX_STRLEN})"
        IntFmt $1 "0x%X" $1
        DetailPrint "$1 - [$3] $2"
    ${EndIf}
    Push 1 # callback's return value
    System::Call "$R0"
    Goto loop
done:
System::Free $R0

sectionend