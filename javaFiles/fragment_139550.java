0x0000000002d53a70: movslq %r11d,%r10
0x0000000002d53a73: lea    0x0(%rbp,%r10,4),%r10
0x0000000002d53a78: mov    0x10(%r10),%ebx    ; ebx = A[j]
0x0000000002d53a7c: mov    0xc(%r10),%r9d     ; r9d = A[j - 1]

0x0000000002d53a80: cmp    %ebx,%r9d          ; if (r9d > ebx) {
0x0000000002d53a83: jle    0x0000000002d539f3 
0x0000000002d53a89: mov    %r9d,0x10(%r10)    ;     A[j] = r9d
0x0000000002d53a8d: mov    %ebx,0xc(%r10)     ;     A[j - 1] = ebx
                                              ; }
0x0000000002d53a91: mov    0x8(%r10),%r9d     ; r9d = A[j - 2]

0x0000000002d53a95: cmp    %ebx,%r9d          ; if (r9d > ebx) {  
0x0000000002d53a98: jle    0x0000000002d539f3                     
0x0000000002d53a9e: mov    %r9d,0xc(%r10)     ;     A[j - 1] = r9d    
0x0000000002d53aa2: mov    %ebx,0x8(%r10)     ;     A[j - 2] = ebx
                                              ; }             
0x0000000002d53aa6: mov    0x4(%r10),%r9d     ; r9d = A[j - 3]    

0x0000000002d53aaa: cmp    %ebx,%r9d          ; if (r9d > ebx) {  
0x0000000002d53aad: jle    0x0000000002d539f3                     
0x0000000002d53ab3: mov    %r9d,0x8(%r10)     ;     A[j - 2] = r9d
0x0000000002d53ab7: mov    %ebx,0x4(%r10)     ;     A[j - 3] = ebx
                                              ; }                 
0x0000000002d53abb: mov    (%r10),%r8d        ; r8d = A[j - 4]

0x0000000002d53abe: cmp    %ebx,%r8d          ; if (r8d > ebx) {
0x0000000002d53ac1: jle    0x0000000002d539f3  
0x0000000002d53ac7: mov    %r8d,0x4(%r10)     ;     A[j - 3] = r8
0x0000000002d53acb: mov    %ebx,(%r10)        ;     A[j - 4] = ebx
                                              ; }
0x0000000002d53ace: add    $0xfffffffc,%r11d  ; j -= 4
0x0000000002d53ad2: cmp    $0x3,%r11d         ; while (j > 3)
0x0000000002d53ad6: jg     0x0000000002d53a70