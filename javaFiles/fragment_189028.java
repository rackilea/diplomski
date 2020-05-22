@Entity
@XmlRootElement
public class Attachment {

    private String name;

    private String mimeType;

    private byte[] dataPart;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType( String mimeType ) {
        this.mimeType = mimeType;
    }

    @XmlJavaTypeAdapter( DuplexBase64MarshallAdapter.class )
    public byte[] getDataPart() {

        return dataPart.clone();
    }

    public void setDataPart( byte[] dataPart ) {
        this.dataPart = dataPart.clone();
    }
}