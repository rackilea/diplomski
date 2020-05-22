public class DeviceDeserializer extends JsonDeserializer<SfPojo> {
    @Override
    public SfPojo deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        // while (p.nextToken()!=null) {
        //     if (p.getCurrentToken()==)
        // }
        String temp = p.readValueAsTree().toString();
        ObjectMapper mapper = new ObjectMapper();
        SfPojoDto sfPojoDto = mapper.readValue(temp, SfPojoDto.class);
        SfPojo sfPojo = new SfPojo();
        sfPojo.setDevice(sfPojoDto.getDevice());
        List<Ifce> ifceList = sfPojoDto.getIfces();
        for (Ifce ifce : ifceList) {
            List<String> capabilities = Arrays.asList(ifce.getCapabilites());
            if (capabilities.contains("ETHERNET")) {
                sfPojo.setPort(ifce.getPort());
                sfPojo.setReservbleBw(ifce.getReservableBW());
                return sfPojo;
            }
        }
        return sfPojo;
    }
}