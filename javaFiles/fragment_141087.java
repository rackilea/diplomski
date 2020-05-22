adrpo33@computer MINGW64 /c/home/adrpo33/dev/OMTesting/mb
$ ./TestJAVA_v2.exe -override=bodyShape1.r[1]=2 -lv=LOG_ALL | grep 'bodyShape1.r\['
LOG_SOLVER        | info    | read override values: bodyShape1.r[1]=2
LOG_SOLVER        | info    | override bodyShape1.r[1] = 2
|                 | |       | | Real bodyShape1.r[1](start=2, fixed=true, {nominal=1}, min=-1.79769e+308, max=1.79769e+308)
|                 | |       | | Real bodyShape1.r[2](start=1, fixed=true, {nominal=1}, min=-1.79769e+308, max=1.79769e+308)
|                 | |       | | Real bodyShape1.r[3](start=1, fixed=true, {nominal=1}, min=-1.79769e+308, max=1.79769e+308)
|                 | |       | | | [87] parameter Real bodyShape1.r[1](start=2, fixed=true) = 2
|                 | |       | | | [88] parameter Real bodyShape1.r[2](start=1, fixed=true) = 1
|                 | |       | | | [89] parameter Real bodyShape1.r[3](start=1, fixed=true) = 1