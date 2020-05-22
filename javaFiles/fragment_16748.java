# {method} {0x0000000017498a48} 'lookupSwitch' '(I)I' in 'bench/Switch'
  # parm0:    rdx       = int
  #           [sp+0x20]  (sp of caller)
  0x000000000329b240: sub    $0x18,%rsp
  0x000000000329b247: mov    %rbp,0x10(%rsp)    ;*synchronization entry
                                                ; - bench.Switch::lookupSwitch@-1

  0x000000000329b24c: cmp    $0x4,%edx
  0x000000000329b24f: je     0x000000000329b2a5
  0x000000000329b251: cmp    $0x4,%edx
  0x000000000329b254: jg     0x000000000329b281
  0x000000000329b256: cmp    $0x2,%edx
  0x000000000329b259: je     0x000000000329b27a
  0x000000000329b25b: cmp    $0x2,%edx
  0x000000000329b25e: jg     0x000000000329b273
  0x000000000329b260: cmp    $0x1,%edx
  0x000000000329b263: jne    0x000000000329b26c  ;*lookupswitch
                                                 ; - bench.Switch::lookupSwitch@1
  ...