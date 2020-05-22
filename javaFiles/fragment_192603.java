import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class Base64Serializer<T extends Serializable> extends StdSerializer<T> {

    private static final long serialVersionUID = 1L;

    protected Base64Serializer(Class<?> t, boolean f) {
        super(t, f);
    }

    @Override
    public void serialize(T value, JsonGenerator jsonGenerator, SerializerProvider arg2) throws IOException {
        String ecnodedOutput = Base64.getEncoder().encodeToString(serialize(value));
        jsonGenerator.writeString(ecnodedOutput);
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }
}