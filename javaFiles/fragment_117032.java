public void testSimpleMessageNano() throws Exception {
    SimpleMessageNano msg = new SimpleMessageNano();
    assertEquals(123, msg.d);
    assertEquals(null, msg.nestedMsg);
    assertEquals(SimpleMessageNano.BAZ, msg.defaultNestedEnum);

    msg.d = 456;
    assertEquals(456, msg.d);

    SimpleMessageNano.NestedMessage nestedMsg = new SimpleMessageNano.NestedMessage();
    nestedMsg.bb = 2;
    assertEquals(2, nestedMsg.bb);
    msg.nestedMsg = nestedMsg;
    assertEquals(2, msg.nestedMsg.bb);

    msg.defaultNestedEnum = SimpleMessageNano.BAR;
    assertEquals(SimpleMessageNano.BAR, msg.defaultNestedEnum);

    byte [] result = MessageNano.toByteArray(msg);
    int msgSerializedSize = msg.getSerializedSize();
    //System.out.printf("mss=%d result.length=%d\n", msgSerializedSize, result.length);
    assertTrue(msgSerializedSize == 9);
    assertEquals(result.length, msgSerializedSize);

    SimpleMessageNano newMsg = SimpleMessageNano.parseFrom(result);
    assertEquals(456, newMsg.d);
    assertEquals(2, msg.nestedMsg.bb);
    assertEquals(SimpleMessageNano.BAR, msg.defaultNestedEnum);
  }