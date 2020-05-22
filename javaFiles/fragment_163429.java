String firstblock = “If debugging is thae process of removing software bugs, then programming must be the process of putting them in. Most good programmers do programming not because they expect to get paid or get adulation by the public, but because it is fun to program.”;
  byte[] bytes = firstblock.getBytes();
  StringBuilder binary = new StringBuilder();
  for (byte b : bytes)
  {
     int val = b;
     for (int i = 0; i < 8; i++)
     {
        binary.append((val & 128) == 0 ? 0 : 1);
        val <<= 1;
     }
     binary.append(' ');
  }
  System.out.println(binary);