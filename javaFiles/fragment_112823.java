String hex = "5A109061"; // mEditText.getText().toString()

// Parse hex to int
int value = Integer.parseInt(hex, 16);

// Flip byte order using ByteBuffer
ByteBuffer buffer = ByteBuffer.allocate(4);
buffer.order(ByteOrder.BIG_ENDIAN);
buffer.asIntBuffer().put(value);
buffer.order(ByteOrder.LITTLE_ENDIAN);
int flipped = buffer.asIntBuffer().get();

System.out.println("hex: 0x" + hex);
System.out.println("flipped: " + flipped);