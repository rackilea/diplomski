package my.pack.age;

import com.sun.jersey.core.provider.AbstractMessageReaderWriterProvider;
import com.sun.jersey.core.util.ReaderWriter;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Produces("application/vnd.stupidNameThatReallyIsJustJSON+json")
public class MyJsonBodyWriter<T> extends AbstractMessageReaderWriterProvider<T> {

    // T should be your pojo in this case. If you can make your pojo compatible with org.codehaus.jettison.json.JSONObject,
    // then you can extend com.sun.jersey.json.impl.provider.entity.JSONObjectProvider and delegate all the methods of
    // MessageBodyWriter (and MessageBodyReader) to that. Otherwise just implement them.

    @Override
    public T readFrom(Class<T> type, Type genericType, Annotation annotations[], MediaType mediaType,MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException {
        try {
//            deserialize entityStream according to the given media type and return a new instance of T.
//            
//            You can do it like this (just an example) :
//            JSONObject myObject = new JSONObject();
//            try {
//                these names and values should come from the stream.
//                myObject.put("name", "Agamemnon");
//                myObject.put("age", 32);
//            } catch (JSONException ex) {
//                LOGGER.log(Level.SEVERE, "Error ...", ex);
//            }
            return null;
        } catch (Exception e) {
            throw new WebApplicationException(new Exception("Error during deserialization", e),400);
        }
    }

        @Override
    public void writeTo(T t,Class<?> type, Type genericType, Annotation annotations[], MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(entityStream, ReaderWriter.getCharset(mediaType));
            // write t on the writer
            writer.flush();
        } catch (Exception e) {
            throw new WebApplicationException( new Exception("Error during serialization", e), 500);
        }
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        // should return true if this class can serialize the given type to the given media type
        return true;
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        // should return true if this class can deserialize the given type to the given media type
        return true;
    }

    @Override
    public long getSize(T t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        // calculate and return content-lenght, i.e. the lenght of the serialized representation of t
        return 0;
    }

}