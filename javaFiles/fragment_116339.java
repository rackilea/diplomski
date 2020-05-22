# {method} 'isEvenMod' '(I)Z' in 'javaapplication4/Test1'
  # parm0:    rdx       = int
  #           [sp+0x20]  (sp of caller)
  0x00000000026c2780: sub    rsp,0x18
  0x00000000026c2787: mov    QWORD PTR [rsp+0x10],rbp  ;*synchronization entry
                                                ; - javaapplication4.Test1::isEvenMod@-1 (line 63)
  0x00000000026c278c: mov    r10d,edx
  0x00000000026c278f: and    r10d,0x1           ;*irem
                                                ; - javaapplication4.Test1::isEvenMod@2 (line 63)
  0x00000000026c2793: mov    r11d,r10d
  0x00000000026c2796: neg    r11d
  0x00000000026c2799: test   edx,edx
  0x00000000026c279b: cmovl  r10d,r11d
  0x00000000026c279f: test   r10d,r10d
  0x00000000026c27a2: setne  al
  0x00000000026c27a5: movzx  eax,al
  0x00000000026c27a8: xor    eax,0x1            ;*ireturn
                                                ; - javaapplication4.Test1::isEvenMod@11 (line 63)
  0x00000000026c27ab: add    rsp,0x10
  0x00000000026c27af: pop    rbp
  0x00000000026c27b0: test   DWORD PTR [rip+0xfffffffffdb6d84a],eax        # 0x0000000000230000
                                                ;   {poll_return}
  0x00000000026c27b6: ret