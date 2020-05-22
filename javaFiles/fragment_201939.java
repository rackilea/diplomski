0a8   B11: #    B11 B12 &lt;- B10 B11   Loop: B11-B11 inner stride: not constant post of N161 Freq: 0.999997
0a8     MOV    EBX,[ESI]    # int ! Field  VolatileMain.a
0aa     MEMBAR-acquire ! (empty encoding)
0aa     MEMBAR-release ! (empty encoding)
0aa     INC    EDI
0ab     INC    EBX
0ac     MOV    [ESI],EBX ! Field  VolatileMain.a
0ae     MEMBAR-volatile (unnecessary so empty encoding)
0ae     LOCK ADDL [ESP + #0], 0 ! membar_volatile
0b3     CMP    EDI,#1000000
0b9     Jl,s  B11   # Loop end  P=0.500000 C=126282.000000