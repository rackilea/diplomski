$ java -version
java version "1.7.0_03"
Java(TM) SE Runtime Environment (build 1.7.0_03-b04)
Java HotSpot(TM) Server VM (build 22.1-b02, mixed mode)
$ java -server -XX:+UnlockDiagnosticVMOptions '-XX:CompileCommand=print,*Main.main' Main
CompilerOracle: print *Main.main
Java HotSpot(TM) Server VM warning: printing of assembly code is enabled; turning on DebugNonSafepoints to gain additional output
Compiled method (c2)      68    1 %           Main::main @ 4 (49 bytes)
 total in heap  [0xb3a97548,0xb3a979ec] = 1188
 relocation     [0xb3a97610,0xb3a97624] = 20
 main code      [0xb3a97640,0xb3a97840] = 512
 stub code      [0xb3a97840,0xb3a97850] = 16
 oops           [0xb3a97850,0xb3a97858] = 8
 scopes data    [0xb3a97858,0xb3a97898] = 64
 scopes pcs     [0xb3a97898,0xb3a979e8] = 336
 dependencies   [0xb3a979e8,0xb3a979ec] = 4
Could not load hsdis-i386.so; library not loadable; PrintAssembly is disabled
OopMapSet contains 1 OopMaps