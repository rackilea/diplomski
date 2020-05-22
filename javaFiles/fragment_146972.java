; assume i, j, a, and v are in slots 0-3 respectively
L3: 
iinc 0 1
aload_2
iload_0
bipush 8
imul
iaload
iload_3
if_lt L3
iinc 1 -1