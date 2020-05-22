@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public class ColorsTest {

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp(){
        mapper.registerModule(new Module() {
            @Override
            public String getModuleName() {
                return "my.module";
            }

            @Override
            public Version version() {
                return Version.unknownVersion();
            }

            @Override
            public void setupModule(SetupContext context) {

                context.addBeanSerializerModifier(new BeanSerializerModifier() {
                    @Override
                    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
                        if(beanDesc.getBeanClass().equals(A.class)) {
                            return new CustomSerializer((BeanSerializerBase) serializer, NameTransformer.NOP);
                        }
                        return serializer;
                    }
                });

            }
        });
    }
    @Test
    public void testSerializer() throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(new B()));
    }
}