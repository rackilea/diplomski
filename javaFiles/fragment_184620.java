${If} $JavaHome == ""
  ${OrIfNot} ${FileExists} "$JavaHome\bin\java.exe"
    IfSilent +2
    MessageBox MB_OK|MB_ICONSTOP "No Java Virtual Machine found in folder:$\r$\n$JavaHome"
    DetailPrint "No Java Virtual Machine found in folder:$\r$\n$JavaHome"
    Quit
  ${EndIf}

  StrCpy "$JavaExe" "$JavaHome\bin\java.exe"

  ; Need path to jvm.dll to configure the service - uses $JavaHome
  Call findJVMPath
  Pop $5
  ${If} $5 == ""
    IfSilent +2
    MessageBox MB_OK|MB_ICONSTOP "No Java Virtual Machine found in folder:$\r$\n$5"
    DetailPrint "No Java Virtual Machine found in folder:$\r$\n$5"
    Quit
  ${EndIf}

  ...

; ====================
; FindJVMPath Function
; ====================
;
; Find the full JVM path, and put the result on top of the stack
; Implicit argument: $JavaHome
; Will return an empty string if the path cannot be determined
;
Function findJVMPath

  ClearErrors

  ;Step one: Is this a JRE path (Program Files\Java\XXX)
  StrCpy $1 "$JavaHome"

  StrCpy $2 "$1\bin\hotspot\jvm.dll"
  IfFileExists "$2" FoundJvmDll
  StrCpy $2 "$1\bin\server\jvm.dll"
  IfFileExists "$2" FoundJvmDll
  StrCpy $2 "$1\bin\client\jvm.dll"
  IfFileExists "$2" FoundJvmDll
  StrCpy $2 "$1\bin\classic\jvm.dll"
  IfFileExists "$2" FoundJvmDll

  ;Step two: Is this a JDK path (Program Files\XXX\jre)
  StrCpy $1 "$JavaHome\jre"

  StrCpy $2 "$1\bin\hotspot\jvm.dll"
  IfFileExists "$2" FoundJvmDll
  StrCpy $2 "$1\bin\server\jvm.dll"
  IfFileExists "$2" FoundJvmDll
  StrCpy $2 "$1\bin\client\jvm.dll"
  IfFileExists "$2" FoundJvmDll
  StrCpy $2 "$1\bin\classic\jvm.dll"
  IfFileExists "$2" FoundJvmDll

  ClearErrors
  ;Step tree: Read defaults from registry

  ReadRegStr $1 HKLM "SOFTWARE\JavaSoft\Java Runtime Environment" "CurrentVersion"
  ReadRegStr $2 HKLM "SOFTWARE\JavaSoft\Java Runtime Environment\$1" "RuntimeLib"

  IfErrors 0 FoundJvmDll
  StrCpy $2 ""

  FoundJvmDll:
  ClearErrors

  ; Put the result in the stack
  Push $2

FunctionEnd