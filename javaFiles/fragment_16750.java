# {method} {0x0000000017288a68} 'lookupSwitch' '(I)I' in 'bench/Switch'
  # parm0:    rdx       = int
  #           [sp+0x20]  (sp of caller)
  0x000000000307ecc0: sub    $0x18,%rsp         ;   {no_reloc}
  0x000000000307ecc7: mov    %rbp,0x10(%rsp)    ;*synchronization entry
                                                ; - bench.Switch::lookupSwitch@-1

  0x000000000307eccc: mov    %edx,%r10d
  0x000000000307eccf: dec    %r10d
  0x000000000307ecd2: cmp    $0xa,%r10d
  0x000000000307ecd6: jb     0x000000000307ece9
  0x000000000307ecd8: mov    $0xffffffff,%eax
  0x000000000307ecdd: add    $0x10,%rsp
  0x000000000307ece1: pop    %rbp
  0x000000000307ece2: test   %eax,-0x1faece8(%rip)        # 0x00000000010d0000
                                                ;   {poll_return}
  0x000000000307ece8: retq   
  0x000000000307ece9: movslq %edx,%r10
  0x000000000307ecec: movabs $0x307ec60,%r11    ;   {section_word}
  0x000000000307ecf6: jmpq   *-0x8(%r11,%r10,8)  ;*lookupswitch
                                                ; - bench.Switch::lookupSwitch@1
                      ^^^^^^^^^^^^^^^^^^^^^^^^^