set cmd=notepad

for /f "tokens=2 delims==; " %%a in (' wmic process call create "%cmd%" ^| find "ProcessId" ') do set PID=%%a

start cmd /k echo %pid%

PAUSE