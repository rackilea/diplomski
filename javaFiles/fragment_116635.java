String s = "0000000000A0A240";
double d = ByteBuffer.allocate(8)
                     .putLong(Long.parseUnsignedLong(s, 16))
                     .flip()
                     .order(ByteOrder.LITTLE_ENDIAN)
                     .getDouble();
System.out.println(d); // prints 2384.0