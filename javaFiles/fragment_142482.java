!include x64.nsh
!include LogicLib.nsh

Section
!if "${NSIS_PTR_SIZE}" >= 8
  DetailPrint "64-bit installer"
!else
  ${If} ${RunningX64}
    DetailPrint "32-bit installer on a 64-bit OS"
  ${Else}
    DetailPrint "32-bit installer on a 32-bit OS"
  ${EndIf}
!endif
SectionEnd