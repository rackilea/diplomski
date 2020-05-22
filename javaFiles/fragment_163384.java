;--------------------------------
;Defines

  !define JavaRegKey 'HKLM "Software\JavaSoft\Java Runtime Environment" ""'

;--------------------------------
;Installer Sections
Section 'Java Runtime' SecJava

  SetOutPath '$TEMP'
  SetOverwrite on
  File 'c:\<yourdir>\javasetup.exe'
  ExecWait '$TEMP\javasetup.exe' $0
  DetailPrint '..Java Runtime Setup exit code = $0'
  Delete '$TEMP\javasetup.exe'

SectionEnd

;--------------------------------
;   Functions
Function .onInit

  ReadRegStr $R0 ${JavaRegKey}
  StrCmp $R0 "" JavaMissing JavaFound

  JavaFound: 
  !insertmacro UnselectSection ${SecJava}
  Goto JavaCheckDone

  JavaMissing:
  !insertmacro SelectSection ${SecJava}

  JavaCheckDone:

FunctionEnd