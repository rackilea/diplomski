BigInteger value = new BigInteger("232284873704446901628976");

byte[] littleEndian = value.toByteArray();

byte[] bigEndian = new byte[littleEndian.length];
for (int i = 0; i < littleEndian.length; i++)
    bigEndian[bigEndian.length - i - 1] = littleEndian[i];

System.out.println(Arrays.toString(bigEndian)); // [48, 48, 48, 48, 48, 48, 48, 48, 48, 49]

String string = new String(bigEndian, StandardCharsets.US_ASCII);
System.out.println(string); // 0000000001

int number = Integer.parseInt(string);
System.out.println(number); // 1