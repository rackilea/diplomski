int number = 0;
// simulating arduino using bytearray stream.
ByteArrayInputStream myPort = new ByteArrayInputStream(new byte[] {(byte) 0b11011010, (byte) 0b10100101});
int received = myPort.read();
number = number | (received<<8);
received = myPort.read();
number = number | received;

System.out.println("arduino:  " + number + " == " + Integer.toBinaryString(number));

// reverse the bits to get Java understandable bit order for numeric values
int numericJavaInt = 0;
for(int i=0; i<16; i++) {
    int bit = (number & 1<<(15-i)) == 0 ? 0 : 1;
    numericJavaInt = numericJavaInt | bit<<i;
}

System.out.println("Java-Num: " + numericJavaInt + " == " + Integer.toBinaryString(numericJavaInt));

final int code = numericJavaInt >> 10;
System.out.println("6 upper bits code: " + code + " == " + Integer.toBinaryString(code));