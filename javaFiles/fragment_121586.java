byte[] outData = "$*220000000000101SDFRGGHYB0".getBytes("UTF-8");
ByteBuffer b = ByteBuffer.wrap(outData);

byte[] outputValue1 = new byte[2];
b.get(outputValue1);

byte[] outputValue2 = new byte[2];
b.get(outputValue2);

String outputString1 = new String(outputValue1, "UTF-8");
String outputString2 = new String(outputValue2, "UTF-8");
int outputNum2 = Integer.parseInt(outputString2);