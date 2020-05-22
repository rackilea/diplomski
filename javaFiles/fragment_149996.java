$ java -server -XX:+UnlockDiagnosticVMOptions '-XX:CompileCommand=print,*Main.main' Main
CompilerOracle: print *Main.main
Java HotSpot(TM) Server VM warning: printing of assembly code is enabled; turning on DebugNonSafepoints to gain additional output
Compiled method (c2)      68    1 %           Main::main @ 4 (49 bytes)
 total in heap  [0xb3999548,0xb39999ec] = 1188
 relocation     [0xb3999610,0xb3999624] = 20
 main code      [0xb3999640,0xb3999840] = 512
 stub code      [0xb3999840,0xb3999850] = 16
 oops           [0xb3999850,0xb3999858] = 8
 scopes data    [0xb3999858,0xb3999898] = 64
 scopes pcs     [0xb3999898,0xb39999e8] = 336
 dependencies   [0xb39999e8,0xb39999ec] = 4
Loaded disassembler from [snip]/jdk1.7.0_03/jre/lib/i386/hsdis-i386.so
Decoding compiled method 0xb3999548:
Code:
[Disassembling for mach='i386']
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} 'main' '([Ljava/lang/String;)V' in 'Main'
  0xb3999640: call   0xb6ff8510         ;   {runtime_call}
  0xb3999645: data32 xchg %ax,%ax
  0xb3999648: mov    %eax,-0x3000(%esp)
  0xb399964f: push   %ebp
  0xb3999650: sub    $0x38,%esp
  0xb3999656: mov    %ecx,%esi
  0xb3999658: mov    0x4(%esi),%ebp
  0xb399965b: mov    0x8(%esi),%edi
  0xb399965e: mov    (%ecx),%esi
  0xb3999660: mov    %ecx,(%esp)
  0xb3999663: call   0xb7078cf0         ;*iload_3
[snip]
  0xb399983e: hlt    
  0xb399983f: hlt    
[Exception Handler]
[Stub Code]
  0xb3999840: jmp    0xb39981e0         ;   {no_reloc}
[Deopt Handler Code]
  0xb3999845: push   $0xb3999845        ;   {section_word}
  0xb399984a: jmp    0xb397e220         ;   {runtime_call}
  0xb399984f: .byte 0x0
OopMapSet contains 1 OopMaps

#0 
OopMap{off=468}