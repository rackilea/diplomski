public static void main(String[] args) throws Exception {
    String os = "whatever os is";
    byte[] avroBinaryValue = os.getBytes();
    String schemaName = "DEMOGRAPHIC";
    long lastModifiedDate = 1379811105109L;

    byte[] schemaNameBytes = schemaName.getBytes();

    ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(byteOs);
    out.writeInt(avroBinaryValue.length);
    out.write(avroBinaryValue);
    out.writeInt(schemaNameBytes.length);
    out.write(schemaNameBytes);
    out.writeLong(lastModifiedDate);

    // write done

    byte[] allWrittenBytes = byteOs.toByteArray();

    DataInputStream in = new DataInputStream(new ByteArrayInputStream(allWrittenBytes));

    int sizeAvro = in.readInt();
    avroBinaryValue = new byte[sizeAvro];
    in.read(avroBinaryValue, 0, sizeAvro);

    int sizeSchema = in.readInt();
    schemaNameBytes = new byte[sizeSchema];
    in.read(schemaNameBytes, 0, sizeSchema);

    lastModifiedDate = in.readLong();

    // read done

    System.out.println(new String(avroBinaryValue));
    System.out.println(new String(schemaNameBytes));
    System.out.println(lastModifiedDate);
}