final int a = Integer.parseInt("FFF7", 16); // 0b1111111111110111
final int b = Integer.parseInt("0001", 16); // 0b0000000000000001

final int result = a & b;

final String output = String.format("%16s", 
    Integer.toBinaryString(result)).replace(' ', '0');

System.out.println(output);