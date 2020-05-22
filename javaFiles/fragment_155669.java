byte[] buffer = new byte[100];
int index = 0;

public void recordByte(Byte b) {
   index = (index + 1) % 100;
   buffer[index] = b; 
}

public void print() {
   for(int i = index; i < index + 100; i++) {
       System.out.print(buffer[i % 100]);
   }
}