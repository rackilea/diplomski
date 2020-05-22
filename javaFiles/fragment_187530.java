Field address = Buffer.class.getDeclaredField("address");
address.setAccessible(true);
Field capacity = Buffer.class.getDeclaredField("capacity");
capacity.setAccessible(true);

ByteBuffer bb = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
address.setLong(bb, addressYouWantToSet);
capacity.setInt(bb, theSizeOf);