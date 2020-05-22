ByteArrayOutputStream out = new ByteArrayOutputStream();
{
    // conversion from "yourObject" to byte[]
    DataOutputStream dos = new DataOuputStream(out);
    dos.writeInt(yourObject.intProperty);
    dos.writeByte(yourObject.byteProperty);
    dos.writeFloat(yourObject.floatProperty);
    dos.writeChars(yourObject.stringProperty);
    dos.close();
}
byte[] byteArray = out.toByteArray();