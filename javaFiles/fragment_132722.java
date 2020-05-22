${If} ${RunningX64}
  SetRegView 64
  ${registry::Read} ... $0 $1
  ...
${EndIf}
SetRegView 32
${If} $0 == "" 
  ${registry::Read} ... $0 $1
  ...
${EndIf}