[Constants]
  0x00007ff2e4dbbd20 (offset:    0): 0x54442d18   0x3fe921fb54442d18
  0x00007ff2e4dbbd24 (offset:    4): 0x3fe921fb
  0x00007ff2e4dbbd28 (offset:    8): 0xf4f4f4f4   0xf4f4f4f4f4f4f4f4
  0x00007ff2e4dbbd2c (offset:   12): 0xf4f4f4f4
  0x00007ff2e4dbbd30 (offset:   16): 0xf4f4f4f4   0xf4f4f4f4f4f4f4f4
  0x00007ff2e4dbbd34 (offset:   20): 0xf4f4f4f4
  0x00007ff2e4dbbd38 (offset:   24): 0xf4f4f4f4   0xf4f4f4f4f4f4f4f4
  0x00007ff2e4dbbd3c (offset:   28): 0xf4f4f4f4
  (snip)
[Verified Entry Point]
  0x00007ff2e4dbbd50: sub     $0x28,%rsp
  0x00007ff2e4dbbd57: mov     %rbp,0x20(%rsp)   ;*synchronization entry
                                                ; - stackoverflow.TrigBench::testMethod@-1 (line 38)

  0x00007ff2e4dbbd5c: vmovsd  0x10(%rsi),%xmm2  ;*getfield i
                                                ; - stackoverflow.TrigBench::testMethod@1 (line 38)

  0x00007ff2e4dbbd61: vmovapd %xmm2,%xmm1
  0x00007ff2e4dbbd65: sub     $0x8,%rsp
  0x00007ff2e4dbbd69: vmovsd  %xmm1,(%rsp)
  0x00007ff2e4dbbd6e: fldl    (%rsp)
  0x00007ff2e4dbbd71: fsin
  0x00007ff2e4dbbd73: fstpl   (%rsp)
  0x00007ff2e4dbbd76: vmovsd  (%rsp),%xmm1
  0x00007ff2e4dbbd7b: add     $0x8,%rsp         ;*invokestatic sin
                                                ; - stackoverflow.TrigBench::testMethod@20 (line 40)

  0x00007ff2e4dbbd7f: vmovsd  0xffffff99(%rip),%xmm3  ;   {section_word}
  0x00007ff2e4dbbd87: vandpd  0xffe68411(%rip),%xmm2,%xmm0
                                                ;   {external_word}
  0x00007ff2e4dbbd8f: vucomisd %xmm0,%xmm3
  0x00007ff2e4dbbd93: jnb     0x7ff2e4dbbe4c
  0x00007ff2e4dbbd99: vmovq   %xmm3,%r13
  0x00007ff2e4dbbd9e: vmovq   %xmm1,%rbp
  0x00007ff2e4dbbda3: vmovq   %xmm2,%rbx
  0x00007ff2e4dbbda8: vmovapd %xmm2,%xmm0
  0x00007ff2e4dbbdac: movabs  $0x7ff2f9abaeec,%r10
  0x00007ff2e4dbbdb6: callq   %r10
  0x00007ff2e4dbbdb9: vmovq   %xmm0,%r14
  0x00007ff2e4dbbdbe: vmovq   %rbx,%xmm2
  0x00007ff2e4dbbdc3: vmovq   %rbp,%xmm1
  0x00007ff2e4dbbdc8: vmovq   %r13,%xmm3
  0x00007ff2e4dbbdcd: vandpd  0xffe683cb(%rip),%xmm2,%xmm0
                                                ;*invokestatic sin
                                                ; - stackoverflow.TrigBench::testMethod@4 (line 38)
                                                ;   {external_word}
  0x00007ff2e4dbbdd5: vucomisd %xmm0,%xmm3
  0x00007ff2e4dbbdd9: jnb     0x7ff2e4dbbe56
  0x00007ff2e4dbbddb: vmovq   %xmm3,%r13
  0x00007ff2e4dbbde0: vmovq   %xmm1,%rbp
  0x00007ff2e4dbbde5: vmovq   %xmm2,%rbx
  0x00007ff2e4dbbdea: vmovapd %xmm2,%xmm0
  0x00007ff2e4dbbdee: movabs  $0x7ff2f9abaeec,%r10
  0x00007ff2e4dbbdf8: callq   %r10
  0x00007ff2e4dbbdfb: vmovsd  %xmm0,(%rsp)
  0x00007ff2e4dbbe00: vmovq   %rbx,%xmm2
  0x00007ff2e4dbbe05: vmovq   %rbp,%xmm1
  0x00007ff2e4dbbe0a: vmovq   %r13,%xmm3        ;*invokestatic sin
                                                ; - stackoverflow.TrigBench::testMethod@12 (line 39)

  0x00007ff2e4dbbe0f: vandpd  0xffe68389(%rip),%xmm2,%xmm0
                                                ;*invokestatic sin
                                                ; - stackoverflow.TrigBench::testMethod@4 (line 38)
                                                ;   {external_word}
  0x00007ff2e4dbbe17: vucomisd %xmm0,%xmm3
  0x00007ff2e4dbbe1b: jnb     0x7ff2e4dbbe32
  0x00007ff2e4dbbe1d: vmovapd %xmm2,%xmm0
  0x00007ff2e4dbbe21: movabs  $0x7ff2f9abaeec,%r10
  0x00007ff2e4dbbe2b: callq   %r10
  0x00007ff2e4dbbe2e: vmovapd %xmm0,%xmm1       ;*invokestatic sin
                                                ; - stackoverflow.TrigBench::testMethod@20 (line 40)

  0x00007ff2e4dbbe32: vmovq   %r14,%xmm0
  0x00007ff2e4dbbe37: vaddsd  (%rsp),%xmm0,%xmm0
  0x00007ff2e4dbbe3c: vaddsd  %xmm0,%xmm1,%xmm0  ;*dadd
                                                ; - stackoverflow.TrigBench::testMethod@30 (line 41)

  0x00007ff2e4dbbe40: add     $0x20,%rsp
  0x00007ff2e4dbbe44: pop     %rbp
  0x00007ff2e4dbbe45: test    %eax,0x15f461b5(%rip)  ;   {poll_return}
  0x00007ff2e4dbbe4b: retq
  0x00007ff2e4dbbe4c: vmovq   %xmm1,%r14
  0x00007ff2e4dbbe51: jmpq    0x7ff2e4dbbdcd
  0x00007ff2e4dbbe56: vmovsd  %xmm1,(%rsp)
  0x00007ff2e4dbbe5b: jmp     0x7ff2e4dbbe0f