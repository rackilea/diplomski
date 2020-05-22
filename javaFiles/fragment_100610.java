x = 0, y = 0

  CPU 1            CPU2
  mov [x], 1       loop:
  mov [y], 1         mov r, [y]
                     jrz loop   ;Jump if r is 0
                   mov s, [x]