synchronized(mutex) {
     transmitEnable.high();
     awaitingEcho = true;
     expectedEcho = "test\n";
     serial.writeln("test");
 }