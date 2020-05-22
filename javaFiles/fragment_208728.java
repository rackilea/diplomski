Decoding compiled method 0x000000000286fbd0:
Code:
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} {0x000000001c0003b0} &apos;testMulti&apos; &apos;(I)I&apos; in &apos;BitShiftOptimization&apos;
  # parm0:    rdx       = int
  #           [sp+0x40]  (sp of caller)
  0x000000000286fd20: mov    %eax,-0x6000(%rsp)
  0x000000000286fd27: push   %rbp
  0x000000000286fd28: sub    $0x30,%rsp
  0x000000000286fd2c: movabs $0x1c0005a8,%rax   ;   {metadata(method data for {method} {0x000000001c0003b0} &apos;testMulti&apos; &apos;(I)I&apos; in &apos;BitShiftOptimization&apos;)}
  0x000000000286fd36: mov    0xdc(%rax),%esi
  0x000000000286fd3c: add    $0x8,%esi
  0x000000000286fd3f: mov    %esi,0xdc(%rax)
  0x000000000286fd45: movabs $0x1c0003a8,%rax   ;   {metadata({method} {0x000000001c0003b0} &apos;testMulti&apos; &apos;(I)I&apos; in &apos;BitShiftOptimization&apos;)}
  0x000000000286fd4f: and    $0x1ff8,%esi
  0x000000000286fd55: cmp    $0x0,%esi
  0x000000000286fd58: je     0x000000000286fd70  ;*iload_0
                        ; - BitShiftOptimization::testMulti@0 (line 17)

  0x000000000286fd5e: shl    $0x8,%edx
  0x000000000286fd61: mov    %rdx,%rax
  0x000000000286fd64: add    $0x30,%rsp
  0x000000000286fd68: pop    %rbp
  0x000000000286fd69: test   %eax,-0x273fc6f(%rip)        # 0x0000000000130100
                        ;   {poll_return}
  0x000000000286fd6f: retq   
  0x000000000286fd70: mov    %rax,0x8(%rsp)
  0x000000000286fd75: movq   $0xffffffffffffffff,(%rsp)
  0x000000000286fd7d: callq  0x000000000285f160  ; OopMap{off=98}
                        ;*synchronization entry
                        ; - BitShiftOptimization::testMulti@-1 (line 17)
                        ;   {runtime_call}
  0x000000000286fd82: jmp    0x000000000286fd5e
  0x000000000286fd84: nop
  0x000000000286fd85: nop
  0x000000000286fd86: mov    0x2a8(%r15),%rax
  0x000000000286fd8d: movabs $0x0,%r10
  0x000000000286fd97: mov    %r10,0x2a8(%r15)
  0x000000000286fd9e: movabs $0x0,%r10
  0x000000000286fda8: mov    %r10,0x2b0(%r15)
  0x000000000286fdaf: add    $0x30,%rsp
  0x000000000286fdb3: pop    %rbp
  0x000000000286fdb4: jmpq   0x0000000002859420  ;   {runtime_call}
  0x000000000286fdb9: hlt    
  0x000000000286fdba: hlt    
  0x000000000286fdbb: hlt    
  0x000000000286fdbc: hlt    
  0x000000000286fdbd: hlt    
  0x000000000286fdbe: hlt