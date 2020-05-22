String[] parts = my.split(" ");
byte[] bytes = new byte[parts.length];

for(int i = 0; i < parts.length; i++) {
  bytes[i] = Byte.parseByte(parts[i]);
}

System.out.println(Arrays.toString(bytes));