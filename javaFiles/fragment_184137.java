public class BinaryDataOrStringOrXMLTransformerimplements Transformer<BinaryDataOrStringOrXML, String> {
  public String transformTo(BinaryDataOrStringOrXML in) {
    return Base64.getEncoder().encodeToString(in.getData());
  }

  public BinaryDataOrStringOrXML transformFrom(String in) {
    return new BinaryDataOrStringOrXML(Base64.getDecoder().decode(in));
  }
}