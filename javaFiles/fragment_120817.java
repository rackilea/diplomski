double[] doubles = new double[]{1.2, 3.5, 4};

int[] floatsAsInts = Arrays.stream(doubles)
     .mapToInt(d -> Float.floatToRawIntBits((float) d))
     .toArray();

Arrays.stream(floatsAsInts)
     .forEach(i -> System.out.println(Float.intBitsToFloat(i)));