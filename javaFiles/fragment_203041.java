package org.lightadmin.core.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.map.module.SimpleDeserializers;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.module.SimpleSerializers;
import org.codehaus.jackson.map.ser.std.SerializerBase;
import org.springframework.hateoas.Resource;

public class DomainTypeResourceModule extends SimpleModule {

    private final DomainTypeToResourceConverter domainTypeToResourceConverter;

    public DomainTypeResourceModule(final DomainTypeToResourceConverter domainTypeToResourceConverter) {
        super("DomainTypeResourceModule", Version.unknownVersion());

        this.domainTypeToResourceConverter = domainTypeToResourceConverter;
    }

    @Override
    public void setupModule(final SetupContext context) {
        SimpleSerializers serializers = new SimpleSerializers();
        serializers.addSerializer(DomainTypeResource.class, new DomainTypeResourceSerializer());
        serializers.addSerializer(Date.class, new JsonDateSerializer());

        SimpleDeserializers deserializers = new SimpleDeserializers();
        deserializers.addDeserializer(Date.class, new JsonDateDeserializer());

        context.addDeserializers(deserializers);
        context.addSerializers(serializers);
    }

    private class DomainTypeResourceSerializer extends SerializerBase<DomainTypeResource> {

        protected DomainTypeResourceSerializer() {
            super(DomainTypeResource.class);
        }

        @Override
        public void serialize(DomainTypeResource value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            if (null == value) {
                provider.defaultSerializeNull(jgen);
                return;
            }

            final Resource resource = domainTypeToResourceConverter.convert(value.getResource(), value.getConfigurationUnitType(), value.getFieldMetadatas());

            jgen.writeObject(resource);
        }
    }

    private class JsonDateSerializer extends SerializerBase<Date> {

        protected JsonDateSerializer() {
            super(Date.class);
        }

        @Override
        public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = date == null ? "" : dateFormat.format(date);

            gen.writeString(formattedDate);
        }

    }

    private class JsonDateDeserializer extends StdDeserializer<Date> {

        protected JsonDateDeserializer() {
            super(Date.class);
        }

        @Override
        public Date deserialize(JsonParser json, DeserializationContext context) throws IOException, JsonProcessingException {

            try {
                if(json.getText() != null && !"".equals(json.getText().trim())) {
                    try {
                        return new Date(Long.parseLong(json.getText()));
                    }
                    catch(NumberFormatException nex){
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        return dateFormat.parse(json.getText());
                    }
                }
                else return null;
            }
            catch (ParseException e){
                return null;
            }
        }

    }

}