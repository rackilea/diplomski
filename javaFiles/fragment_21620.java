ByteBuffer bytes = ByteBuffer.allocate(fileSize);
bytes.order(ByteOrder.LITTLE_ENDIAN);

bytes.putShort((short) 0);
bytes.putShort((short) 1);
bytes.putShort((short) 1);
bytes.put((byte) img.getWidth());
bytes.put((byte) img.getHeight()); //no need to multiply
bytes.put((byte) img.getColorModel().getNumColorComponents()); //the pallet size
bytes.put((byte) 0);
bytes.putShort((short) 1); //should be 1
bytes.putShort((short) img.getColorModel().getPixelSize()); //bits per pixel
bytes.putInt(imgBytes.length);
bytes.putInt(22);
bytes.put(imgBytes);