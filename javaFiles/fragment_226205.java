# {method} 'loop' '()V' in 'test/TestClient'
0x000000010e3c2500: callq  0x000000010dc1c202  ;   {runtime_call}
0x000000010e3c2505: data32 data32 nopw 0x0(%rax,%rax,1)
0x000000010e3c2510: sub    $0x18,%rsp
0x000000010e3c2517: mov    %rbp,0x10(%rsp)
0x000000010e3c251c: mov    %rsi,%rdi
0x000000010e3c251f: movabs $0x10dc760ec,%r10
0x000000010e3c2529: callq  *%r10              ;*iload_3
                                              ; - test.TestClient::loop@12 (line 9)
0x000000010e3c252c: add    $0x10,%rsp
0x000000010e3c2530: pop    %rbp
0x000000010e3c2531: test   %eax,-0x1c18537(%rip)        # 0x000000010c7aa000
                                              ;   {poll_return}
0x000000010e3c2537: retq