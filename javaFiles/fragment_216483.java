DataInputStream dIn = new DataInputStream(socket.getInputStream());
int imageBytesLength = dIn.readInt();  
byte[] imageBytes= new byte[imageBytesLength];
dIn.readFully(imageBytes, 0, imageBytesLength); 
int jsonBytesLength = dIn.readInt();  
byte[] jsonBytes= new byte[jsonBytesLength ];
dIn.readFully(jsonBytesLength , 0, jsonBytesLength );