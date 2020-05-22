Runtime runtime = Runtime.getRuntime();
System.out.printf("total: %11d   max: %d%n", runtime.totalMemory(), runtime.maxMemory());
System.out.printf("used:  %11d%n", runtime.totalMemory() - runtime.freeMemory());
System.gc();
System.out.printf("gc:    %11d%n", runtime.totalMemory() - runtime.freeMemory());
byte[][] memoryWaster = new byte[1024][1_048_576];
memoryWaster[0][0] = 2; // prevent unused warning
System.out.printf("new[]: %11d%n", runtime.totalMemory() - runtime.freeMemory());
System.gc();
System.out.printf("gc:    %11d%n", runtime.totalMemory() - runtime.freeMemory());
memoryWaster = null;
System.out.printf("null:  %11d%n", runtime.totalMemory() - runtime.freeMemory());
System.gc();
System.out.printf("gc:    %11d%n", runtime.totalMemory() - runtime.freeMemory());