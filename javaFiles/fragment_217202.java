import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.Encoder;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonWriter;
...
public void writeAsJsonTo(AggregateIterable<Document> orderCollection,
        HttpServletResponse httpServletResponse) throws IOException {
    final Encoder<Document> encoder = new DocumentCodec();
    final JsonWriter jsonWriter =
        new JsonWriter(httpServletResponse.getWriter());
    final EncoderContext encoderContext = EncoderContext.builder()
        .isEncodingCollectibleDocument(true).build();

    jsonWriter.writeStartDocument();
    jsonWriter.writeStartArray("orders");
    // Going through all documents (thousands of document)
    for (Document orderDocument : orderCollection) {
        encoder.encode(jsonWriter, orderDocument, encoderContext);
    }
    jsonWriter.writeEndArray();
    jsonWriter.writeEndDocument();
}