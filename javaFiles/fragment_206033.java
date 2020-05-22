ByteBuffer buffer = ByteBuffer.allocate(1000); 
buffer.order(ByteOrder.LITTLE_ENDIAN);         
buffer.putChar((char) 12);                     
buffer.putChar((char) 259);                    
buffer.putChar((char) 3);                      
buffer.putInt(1);                              
buffer.putInt(1);                              
byte[] bytes = buffer.array();