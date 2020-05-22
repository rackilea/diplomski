String string = String.format("%010d", 1); // I hope this format is correct

byte[] bigEndian    = string.getBytes(StandardCharsets.US_ASCII);
System.out.println(Arrays.toString(bigEndian)); // [48, 48, 48, 48, 48, 48, 48, 48, 48, 49]

byte[] littleEndian = new byte[bigEndian.length];
for (int i = 0; i < bigEndian.length; i++)
    littleEndian[littleEndian.length - i - 1] = bigEndian[i];

BigInteger value = new BigInteger(littleEndian);
System.out.println(value); // 232284873704446901628976