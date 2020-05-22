final int value = 0x65;                            // we can declare it in hex
final int sameValue = 101;                         // or in decimal

System.out.println(value);                         // output in base 10; prints "101"
System.out.println(Integer.toHexString(value));    // output in base 16; prints "65"
System.out.println(Integer.toBinaryString(value)); // output in base 2; prints "1100101"

System.out.println(""+(value == sameValue));       // prints "true"