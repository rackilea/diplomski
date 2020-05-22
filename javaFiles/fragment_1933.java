BufferedOutputStream out = new BufferedOutputStream(  
                  new FileOutputStream("bob_FontTool.d2r", false));

ByteBuffer buffer = ByteBuffer.allocate(4).order(ByteOrder.nativeOrder());  
buffer.putInt(8);  
out.write(buffer.array());

out.flush();  
out.close();