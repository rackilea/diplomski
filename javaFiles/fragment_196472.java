# {method} 'run2' '()V' in 'Test2'
#           [sp+0x10]  (sp of caller)
0xb396ce80: mov    %eax,-0x3000(%esp)
0xb396ce87: push   %ebp
0xb396ce88: sub    $0x8,%esp          ;*synchronization entry
                                    ; - Test2::run2@-1 (line 33)
0xb396ce8e: mov    $0xffffffff,%ecx
0xb396ce93: mov    $0xffffffff,%ebx
0xb396ce98: mov    $0x6fa2b2f0,%esi   ;   {oop('Test2')}
0xb396ce9d: mov    0x150(%esi),%ebp
0xb396cea3: mov    0x154(%esi),%edi   ;*getstatic l
                                    ; - Test2::run@0 (line 33)
0xb396cea9: cmp    %ecx,%ebp
0xb396ceab: jne    0xb396ceaf
0xb396cead: cmp    %ebx,%edi
0xb396ceaf: je     0xb396cece         ;*getstatic l
                                    ; - Test2::run@14 (line 37)
0xb396ceb1: mov    $0xfffffffe,%ecx
0xb396ceb6: mov    $0xffffffff,%ebx
0xb396cebb: cmp    %ecx,%ebp
0xb396cebd: jne    0xb396cec1
0xb396cebf: cmp    %ebx,%edi
0xb396cec1: je     0xb396ceeb         ;*return
                                    ; - Test2::run@28 (line 40)
0xb396cec3: add    $0x8,%esp
0xb396cec6: pop    %ebp
0xb396cec7: test   %eax,0xb7732000    ;   {poll_return}
;... lines removed