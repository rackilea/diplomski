byte[] delimiter = "test".getBytes();
byte[] sentence = "this is a test sentence".getBytes();

String[] result = new String(sentence).split(new String(delimiter));
byte[][] resultByte = new byte[result.length][];
for(int i = 0; i < result.length; i++){
    resultByte[i] = result[i].getBytes();
}