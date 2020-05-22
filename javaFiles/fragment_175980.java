ByteBuffer bb = ByteBuffer.allocate(4*8);
    LongBuffer lb = bb.asLongBuffer();

    lb.put(0, -1);
    lb.put(1, 1);
    lb.put(2, Long.MAX_VALUE);
    lb.put(3, Long.MIN_VALUE);

    System.out.println(lb.get(0));
    System.out.println(lb.get(1));
    System.out.println(lb.get(2));
    System.out.println(lb.get(3));