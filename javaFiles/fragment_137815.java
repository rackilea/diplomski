@Override
public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
    objectMapper.registerModule(new Module() {

        @Override
        public String getModuleName() {
            return "it.eng.intesasanpaolo.reng0.be";
        }

        @Override
        public Version version() {
            return Version.unknownVersion();
        }
        @Override
        public void setupModule(SetupContext context) {
            context.addBeanDeserializerModifier(uriOrBeanDeserializerModifier);
        }

    });
}