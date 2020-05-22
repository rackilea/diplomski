# {method} 'loop' '()V' in 'test/TestClient'
0x00000001092c36c0: callq  0x0000000108c1c202  ;   {runtime_call}
0x00000001092c36c5: data32 data32 nopw 0x0(%rax,%rax,1)
0x00000001092c36d0: mov    %eax,-0x14000(%rsp)
0x00000001092c36d7: push   %rbp
0x00000001092c36d8: sub    $0x10,%rsp
0x00000001092c36dc: mov    0x10(%rsi),%r13
0x00000001092c36e0: mov    0x8(%rsi),%ebp
0x00000001092c36e3: mov    (%rsi),%ebx
0x00000001092c36e5: mov    %rsi,%rdi
0x00000001092c36e8: movabs $0x108c760ec,%r10
0x00000001092c36f2: callq  *%r10
0x00000001092c36f5: jmp    0x00000001092c3740
0x00000001092c36f7: add    $0x1,%r13          ;*iload_3
                                              ; - test.TestClient::loop@12 (line 9)
0x00000001092c36fb: inc    %ebx               ;*iinc
                                              ; - test.TestClient::loop@22 (line 9)
0x00000001092c36fd: cmp    $0x5f5e101,%ebx
0x00000001092c3703: jl     0x00000001092c36f7  ;*if_icmpge
                                              ; - test.TestClient::loop@15 (line 9)
0x00000001092c3705: jmp    0x00000001092c3734
0x00000001092c3707: nopw   0x0(%rax,%rax,1)
0x00000001092c3710: mov    %r13,%r8           ;*iload_3
                                              ; - test.TestClient::loop@12 (line 9)
0x00000001092c3713: mov    %r8,%r13
0x00000001092c3716: add    $0x10,%r13         ;*ladd
                                              ; - test.TestClient::loop@20 (line 10)
0x00000001092c371a: add    $0x10,%ebx         ;*iinc
                                              ; - test.TestClient::loop@22 (line 9)
0x00000001092c371d: cmp    $0x5f5e0f2,%ebx
0x00000001092c3723: jl     0x00000001092c3710  ;*if_icmpge
                                              ; - test.TestClient::loop@15 (line 9)
0x00000001092c3725: add    $0xf,%r8           ;*ladd
                                              ; - test.TestClient::loop@20 (line 10)
0x00000001092c3729: cmp    $0x5f5e101,%ebx
0x00000001092c372f: jl     0x00000001092c36fb
0x00000001092c3731: mov    %r8,%r13           ;*iload_3
                                              ; - test.TestClient::loop@12 (line 9)
0x00000001092c3734: inc    %ebp               ;*iinc
                                              ; - test.TestClient::loop@28 (line 8)
0x00000001092c3736: cmp    $0xc350,%ebp
0x00000001092c373c: jge    0x00000001092c376c  ;*if_icmpge
                                              ; - test.TestClient::loop@7 (line 8)
0x00000001092c373e: xor    %ebx,%ebx
0x00000001092c3740: mov    %ebx,%r11d
0x00000001092c3743: inc    %r11d              ;*iload_3
                                              ; - test.TestClient::loop@12 (line 9)
0x00000001092c3746: mov    %r13,%r8
0x00000001092c3749: add    $0x1,%r8           ;*ladd
                                              ; - test.TestClient::loop@20 (line 10)
0x00000001092c374d: inc    %ebx               ;*iinc
                                              ; - test.TestClient::loop@22 (line 9)
0x00000001092c374f: cmp    %r11d,%ebx
0x00000001092c3752: jge    0x00000001092c3759  ;*if_icmpge
                                              ; - test.TestClient::loop@15 (line 9)
0x00000001092c3754: mov    %r8,%r13
0x00000001092c3757: jmp    0x00000001092c3746
0x00000001092c3759: cmp    $0x5f5e0f2,%ebx
0x00000001092c375f: jl     0x00000001092c3713
0x00000001092c3761: mov    %r13,%r10
0x00000001092c3764: mov    %r8,%r13
0x00000001092c3767: mov    %r10,%r8
0x00000001092c376a: jmp    0x00000001092c3729  ;*if_icmpge
                                              ; - test.TestClient::loop@7 (line 8)
0x00000001092c376c: mov    $0x24,%esi
0x00000001092c3771: mov    %r13,%rbp
0x00000001092c3774: data32 xchg %ax,%ax
0x00000001092c3777: callq  0x0000000109298f20  ; OopMap{off=188}
                                              ;*getstatic out
                                              ; - test.TestClient::loop@34 (line 13)
                                              ;   {runtime_call}
0x00000001092c377c: callq  0x0000000108c1c202  ;*getstatic out
                                              ; - test.TestClient::loop@34 (line 13)
                                              ;   {runtime_call}