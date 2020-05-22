0x0000000002b53a00: cmp    %r8d,%r10d          ; if (r10d > r8d) {
0x0000000002b53a03: jle    0x0000000002b53973
0x0000000002b53a09: mov    %r8d,0xc(%rbx)      ;     A[j - 1] = r8d
0x0000000002b53a0d: mov    %r10d,0x10(%rbx)    ;     A[j] = r10d
                                               ; }
0x0000000002b53a11: mov    0xc(%rbx),%r10d     ; r10d = A[j - 1]
0x0000000002b53a15: mov    0x8(%rbx),%r9d      ; r9d = A[j - 2]

0x0000000002b53a19: cmp    %r10d,%r9d          ; if (r9d > r10d) {
0x0000000002b53a1c: jle    0x0000000002b53973
0x0000000002b53a22: mov    %r10d,0x8(%rbx)     ;     A[j - 2] = r10d
0x0000000002b53a26: mov    %r9d,0xc(%rbx)      ;     A[j - 1] = r9d    
                                               ; }
0x0000000002b53a2a: mov    0x8(%rbx),%r8d      ; r8d = A[j - 2]
0x0000000002b53a2e: mov    0x4(%rbx),%r10d     ; r10d = A[j - 3]