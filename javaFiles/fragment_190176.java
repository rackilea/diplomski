Random random = new Random();

    int bufferLength = 20;

    byte[] is1 = new byte[bufferLength];
    byte[] is2 = new byte[bufferLength];
    byte[] average = new byte[bufferLength];

    random.nextBytes(is1);
    random.nextBytes(is2);

    short[] shorts1 = new short[bufferLength/2];
    ByteBuffer.wrap(is1).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts1);

    short[] shorts2 = new short[bufferLength/2];
    ByteBuffer.wrap(is2).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts2);

    short[] result = new short[bufferLength/2];

    for (int i=0; i<result.length; i++) {
        result[i] = (short) ((shorts1[i] + shorts2[i])/2);
    }

    ByteBuffer.wrap(average).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(result);