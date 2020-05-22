0x00007ff9e51bce50: cmp $0xf80036dc,%r10d     ;instance of 'java/util/ArrayList'
0x00007ff9e51bce57: jne L0000                 ;if false go to L0000 (invokeinterface size)
0x00007ff9e51bce59: mov 0x10(%rdx),%ebp       ;*getfield size optimization java.util.ArrayList::size@1 

.....

0x00007ff9e51bce6d: retq
             L0000: mov $0xffffffde,%esi      ; true virtual call starts here
0x00007ff9e51bce73: mov %rdx,(%rsp)
0x00007ff9e51bce77: callq 0x00007ff9e50051a0  ; OopMap{[0]=Oop off=92}
                                              ;*invokeinterface size
                                              ; - edu.jvm.runtime.ExampleBench::sum@6 (line 119)
                                              ;   {runtime_call}