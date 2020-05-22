# {method} 'run2' '()V' in 'Test2'
#           [sp+0x10]  (sp of caller)
0xb3ab9340: mov    %eax,-0x3000(%esp)
0xb3ab9347: push   %ebp
0xb3ab9348: sub    $0x8,%esp          ;*synchronization entry
                                    ; - Test2::run2@-1 (line 32)
0xb3ab934e: mov    $0xffffffff,%ecx
0xb3ab9353: mov    $0xffffffff,%ebx
0xb3ab9358: mov    $0x150,%ebp
0xb3ab935d: movsd  0x6fb7b2f0(%ebp),%xmm0  ;   {oop('Test2')}
0xb3ab9365: movd   %xmm0,%eax
0xb3ab9369: psrlq  $0x20,%xmm0
0xb3ab936e: movd   %xmm0,%edx         ;*getstatic l
                                    ; - Test2::run@0 (line 32)
0xb3ab9372: cmp    %ecx,%eax
0xb3ab9374: jne    0xb3ab9378
0xb3ab9376: cmp    %ebx,%edx
0xb3ab9378: je     0xb3ab93ac
0xb3ab937a: mov    $0xfffffffe,%ecx
0xb3ab937f: mov    $0xffffffff,%ebx
0xb3ab9384: movsd  0x6fb7b2f0(%ebp),%xmm0  ;   {oop('Test2')}
0xb3ab938c: movd   %xmm0,%ebp
0xb3ab9390: psrlq  $0x20,%xmm0
0xb3ab9395: movd   %xmm0,%edi         ;*getstatic l
                                    ; - Test2::run@14 (line 36)
0xb3ab9399: cmp    %ecx,%ebp
0xb3ab939b: jne    0xb3ab939f
0xb3ab939d: cmp    %ebx,%edi
0xb3ab939f: je     0xb3ab93ba         ;*return
;... lines removed