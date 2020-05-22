# {method} 'isEvenBit' '(I)Z' in 'javaapplication4/Test1'
  # parm0:    rdx       = int
  #           [sp+0x20]  (sp of caller)
  0x00000000026c2580: sub    rsp,0x18
  0x00000000026c2587: mov    QWORD PTR [rsp+0x10],rbp  ;*synchronization entry
                                                ; - javaapplication4.Test1::isEvenBit@-1 (line 66)
  0x00000000026c258c: and    edx,0x1
  0x00000000026c258f: mov    eax,edx
  0x00000000026c2591: xor    eax,0x1            ;*ireturn
                                                ; - javaapplication4.Test1::isEvenBit@11 (line 66)
  0x00000000026c2594: add    rsp,0x10
  0x00000000026c2598: pop    rbp
  0x00000000026c2599: test   DWORD PTR [rip+0xfffffffffdb6da61],eax        # 0x0000000000230000
                                                ;   {poll_return}
  0x00000000026c259f: ret