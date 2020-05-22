public class ReadBoolean {
    public interface ClientMetaData {
        @XBRead("//xbdefaultns:internal-flag")
        boolean hasFlag();
    }
    public static void main(String[] args) throws IOException {
      ClientMetaData clientMetaData = new XBProjector().io().url("res://xmlWithBoolean.xml").read(ClientMetaData.class);      
      System.out.println("Has flag:"+clientMetaData.hasFlag());
    }
}