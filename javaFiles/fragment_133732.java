public class CompanyDeserializer extends StdDeserializer<Company> { 

@Autowired
private UserRepository userRepository;

public CompanyDeserializer() { 
    this(null); 
} 

public CompanyDeserializer(Class<?> vc) { 
    super(vc); 
}

@Override
public Company deserialize(JsonParser jp, DeserializationContext ctxt) 
  throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    Company c = new Company();
    //Set the rest of the attributes.
    Long empId = (Long) ((IntNode) node.get("employee")).numberValue();
    c.setEmployee(userRepository.findById(empId).orElse(null)));
    return c;
}