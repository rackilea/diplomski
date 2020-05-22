int  MegaBytes = 1024*1024 ;

          long  freeMemory = Runtime.getRuntime().freeMemory() / MegaBytes;
          long  totalMemory = Runtime.getRuntime().totalMemory() / MegaBytes;
          long  maxMemory = Runtime.getRuntime().maxMemory() / MegaBytes;

          System.out.println("Memory used by JVM: " + (maxMemory - freeMemory));
          System.out.println("freeMemory in JVM: " + freeMemory);
          System.out.println("totalMemory in JVM : " + totalMemory);
          System.out.println("maxMemory in JVM: " + maxMemory);