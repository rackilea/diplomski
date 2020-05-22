; assume i, j, a, and v are in slots 0-3 respectively
L3: 
iinc 0 1
iload_0
bipush 8
imul
; store t1 in a variable for simplicity - you could simplify the code by eliminating the temporary
istore 4
aload_2
iload 4
iaload
istore 5
iload 5
iload_3
if_lt L3
iinc 1 -1