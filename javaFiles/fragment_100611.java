x = 0, y = 0

  CPU 1            CPU2
  mov [x], 1       loop:
  sync               mov r, [y]
  mov [y], 1         jrz loop   ;Jump if r is 0
                   mov s, [x]