import org.apache.commons.codec.binary.Base64;

void example() {    
    String srr = FileUtils.readFileToString(new File("c:\\test.txt"));
    byte b[]; 
    Base64 base64 = new Base64();
    b=base64.decode(srr);
}