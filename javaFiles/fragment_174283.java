import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

    ObjectMapper objectMapper = new ObjectMapper();
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(typeFactory);
    mapper.getDeserializationConfig().with(introspector);
    mapper.getSerializationConfig().with(introspector);

    //To force mapper to include JAXB annotated properties in Json schema
    objectMapper.registerModule(new JaxbAnnotationModule());
    SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
    objectMapper.acceptJsonFormatVisitor(objectMapper.constructType(YOUR_JAXB_CLASS.class), visitor);

    JsonSchema inputSchema = visitor.finalSchema();
    String schemaString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(inputSchema);

    System.out.println(schemaString);