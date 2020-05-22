@Component("jacksonObjectMapper")
    public class CustomObjectMapper extends ObjectMapper {

        @PostConstruct
        public void afterPropertiesSet() throws Exception {

            SerializationConfig serialConfig = getSerializationConfig()     
                        .withDateFormat(null);

                  //any other configuration

            this.setSerializationConfig(serialConfig);
        }
    }