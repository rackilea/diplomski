public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

    DevicePai devicePai = new DevicePai();
    devicePai.setDev_id(reader.getAttribute("dev_id");

    reader.moveDown();
    Agent newAgent = (Agent) context.convertAnother(devicePai, Agent.class));
    devicePai.setAgent(newAgent);
    reader.moveUp();

    return devicePai;

}