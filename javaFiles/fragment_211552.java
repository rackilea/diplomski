FileInputStream stream = new FileInputStream("Path to your class file");
ByteArrayOutputStream buffer = new ByteArrayOutputStream();
int data = stream.read();

while(data != -1){
    buffer.write(data);
    data = stream.read();
}

stream.close();

byte[] classData = buffer.toByteArray();