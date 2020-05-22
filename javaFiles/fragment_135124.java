@Test
public void removeBytesFromStart() {
    ByteBuffer bf = ByteBuffer.allocate(16);
    int expectedCapacity = bf.capacity();
    bf.put("abcdefg".getBytes());

    ByteBuffer expected = ByteBuffer.allocate(16);
    expected.put("defg".getBytes());

    removeBytesFromStart(bf, 3);

    Assert.assertEquals(expectedCapacity, bf.capacity());
    Assert.assertEquals(0, bf.compareTo(expected));
}

@Test
public void removeBytesFromStartInt() {
    ByteBuffer bf = ByteBuffer.allocate(16);
    int expectedCapacity = bf.capacity();
    bf.putInt(1);
    bf.putInt(2);
    bf.putInt(3);
    bf.putInt(4);

    ByteBuffer expected = ByteBuffer.allocate(16);
    expected.putInt(2);
    expected.putInt(3);
    expected.putInt(4);

    removeBytesFromStart2(bf, 4);

    Assert.assertEquals(expectedCapacity, bf.capacity());
    Assert.assertEquals(0, bf.compareTo(expected));
}