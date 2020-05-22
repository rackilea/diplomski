long numRead = 0;
    for (MessageAndOffset messageAndOffset : fetchResponse.messageSet(a_topic, a_partition)) {
          long currentOffset = messageAndOffset.offset();
          if (currentOffset < readOffset) {
             System.out.println("Found an old offset: " + currentOffset + " Expecting: " + readOffset);
             continue;
          }
          readOffset = messageAndOffset.nextOffset();
          ByteBuffer payload = messageAndOffset.message().payload();

          byte[] bytes = new byte[payload.limit()];
          payload.get(bytes);
          System.out.println(String.valueOf(messageAndOffset.offset()) + ": " + new String(bytes, "UTF-8"));
          numRead++;
          a_maxReads--;
    }