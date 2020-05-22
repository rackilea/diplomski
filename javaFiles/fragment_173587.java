import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlMapperApp {

    public static void main(String[] args) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.setDefaultUseWrapper(false);

        Assets assets = new Assets();
        assets.getAssets().add(new Asset());
        assets.getAssets().add(new Asset());

        System.out.println(xmlMapper.writeValueAsString(assets));
    }
}

class AssetXMLSerializer extends JsonSerializer<Asset> {

    private final QName wrapper = new QName("val1_val2");
    @Override
    public void serialize(Asset value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ToXmlGenerator xmlGen = (ToXmlGenerator) gen;

        xmlGen.writeStartObject();
        xmlGen.startWrappedValue(wrapper, wrapper);
        xmlGen.writeStringField("val1", value.getVal1());
        xmlGen.writeStringField("val2", value.getVal2());
        xmlGen.finishWrappedValue(wrapper, wrapper);
        xmlGen.writeEndObject();

    }
}

@JsonRootName("ASSETS")
class Assets {

    @JacksonXmlProperty(localName = "ASSET")
    private List<Asset> assets = new ArrayList<>();

    // getters, setters, toString
}

@JsonSerialize(using = AssetXMLSerializer.class)
class Asset {
    private String val1;
    private String val2;

    // getters, setters, toString
}