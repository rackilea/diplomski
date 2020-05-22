Decoding compiled method 0x00007fb360a1a0d0:
Code:
[Entry Point]
[Constants]
  # {method} 'testEqualsIntern' '()I' in 'Test'
  #           [sp+0x20]  (sp of caller)
  0x00007fb360a1a200: mov    0x8(%rsi),%r10d
  0x00007fb360a1a204: cmp    %r10,%rax
  0x00007fb360a1a207: jne    0x00007fb3609f38a0  ;   {runtime_call}
  0x00007fb360a1a20d: data32 xchg %ax,%ax
[Verified Entry Point]
  0x00007fb360a1a210: push   %rbp
  0x00007fb360a1a211: sub    $0x10,%rsp
  0x00007fb360a1a215: nop                       ;*synchronization entry
                                                ; - Test::testEqualsIntern@-1 (line 8)
  0x00007fb360a1a216: mov    $0x3e8,%eax
  0x00007fb360a1a21b: add    $0x10,%rsp
  0x00007fb360a1a21f: pop    %rbp
  0x00007fb360a1a220: test   %eax,0x6232dda(%rip)        # 0x00007fb366c4d000
                                                ;   {poll_return}
  0x00007fb360a1a226: retq