public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

    DevicePai devicePai = new DevicePai();
    devicePai.setDev_id(reader.getAttribute("dev_id"));

    reader.moveDown();
    Agent agent = new Agent();
    while (reader.hasMoreChildren()) {
        reader.moveDown();
        agentFieldContructor(agent, reader.getNodeName(), reader.getValue());
        reader.moveUp();
    }

    devicePai.setAgent(agent);
    reader.moveUp();