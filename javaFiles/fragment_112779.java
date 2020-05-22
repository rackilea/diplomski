if(extension.equals("png"))
{
    File file = new File(fileName);
    FileInputStream fis = new FileInputStream(file);
    byte[] data = new byte[(int) file.length()];
    fis.read(data);
    fis.close();

    DataOutputStream binaryOut = new DataOutputStream(outS);
    binaryOut.writeBytes("HTTP/1.0 200 OK\r\n");
    binaryOut.writeBytes("Content-Type: image/png\r\n");
    binaryOut.writeBytes("Content-Length: " + data.length);
    binaryOut.writeBytes("\r\n\r\n");
    binaryOut.write(data);

    binaryOut.close();
}