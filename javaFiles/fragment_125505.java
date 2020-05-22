0x00007fe759199d42: test   %r8d,%r8d
0x00007fe759199d45: je     0x00007fe759199d76  ;*irem
                                               ; - org.sample.ScalaBench::isEvenlyDivisible@11 (line 52)
                                               ; - org.sample.ScalaBench::run@10 (line 45)
0x00007fe759199d47: mov    %ecx,%eax
0x00007fe759199d49: cmp    $0x80000000,%eax
0x00007fe759199d4e: jne    0x00007fe759199d58
0x00007fe759199d50: xor    %edx,%edx
0x00007fe759199d52: cmp    $0xffffffffffffffff,%r8d
0x00007fe759199d56: je     0x00007fe759199d5c
0x00007fe759199d58: cltd   
0x00007fe759199d59: idiv   %r8d