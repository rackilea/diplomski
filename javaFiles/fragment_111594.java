int i = Integer.MAX_VALUE / 1024 - 1023;
System.out.println(Integer.toUnsignedString(i) + "=" + Integer.toBinaryString(i));
i = i >>> 10;
System.out.println(Integer.toUnsignedString(i) + "=" + Integer.toBinaryString(i));
i = i << 21;
System.out.println(Integer.toUnsignedString(i) + "=" + Integer.toBinaryString(i));