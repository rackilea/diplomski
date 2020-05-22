# {method} {0x0000000017528b18} 'tableSwitch' '(I)I' in 'bench/Switch'
  # parm0:    rdx       = int
  #           [sp+0x20]  (sp of caller)
  0x000000000332c280: sub    $0x18,%rsp
  0x000000000332c287: mov    %rbp,0x10(%rsp)    ;*synchronization entry
                                                ; - bench.Switch::tableSwitch@-1

  0x000000000332c28c: cmp    $0x4,%edx
  0x000000000332c28f: je     0x000000000332c2e5
  0x000000000332c291: cmp    $0x4,%edx
  0x000000000332c294: jg     0x000000000332c2c1
  0x000000000332c296: cmp    $0x2,%edx
  0x000000000332c299: je     0x000000000332c2ba
  0x000000000332c29b: cmp    $0x2,%edx
  0x000000000332c29e: jg     0x000000000332c2b3
  0x000000000332c2a0: cmp    $0x1,%edx
  0x000000000332c2a3: jne    0x000000000332c2ac  ;*tableswitch
                                                 ; - bench.Switch::tableSwitch@1
  ...