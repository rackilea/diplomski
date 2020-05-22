int[] registers = { 5172, -124, 0, 0 };
    long result = ((long) registers[0] & 0xFFFF) << 48
            | ((long) registers[1] & 0xFFFF) << 32 
            | (registers[2] & 0xFFFF) << 16 
            | (registers[3] & 0xFFFF);
    System.out.println(Long.toBinaryString(result));