@Field(index = Index.NO, store = Store.YES)
@FieldBridge(impl = MyFieldBridge.class)
private byte[] file;


//The file bridge
public class MyFieldBridge implements StringBridge {

    @Override
    public String objectToString(final Object object) {

        byte[] file = (byte[]) object;

        return MagicFileUtil.getTextContent(file)
    }
}