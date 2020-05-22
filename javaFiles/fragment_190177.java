Random random = new Random();

    int bufferLength = 8 * 50;

    byte[] is1 = new byte[bufferLength];
    byte[] is2 = new byte[bufferLength];
    byte[] average = new byte[bufferLength];

    random.nextBytes(is1);
    random.nextBytes(is2);

    System.out.println(bytesToHex(is1));
    System.out.println(bytesToHex(is2));

    int[] ints1 = new int[bufferLength/4];
    ByteBuffer.wrap(is1).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().get(ints1);

    int[] ints2 = new int[bufferLength/4];
    ByteBuffer.wrap(is2).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().get(ints2);

    int[] result = new int[bufferLength/4];

    for (int i=0; i<result.length; i++) {
        result[i] = ((ints1[i] + ints2[i])/2);
    }

    ByteBuffer.wrap(average).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(result);