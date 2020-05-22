public Validator() {   
  }

  // for ProcessA
  public initProcessA(GenericRecord payload) {
    clientId = (String) DataUtils.parseRecord(payload, "clientId");
    deviceId = (String) DataUtils.parseRecord(payload, "deviceId");
    payId = (String) DataUtils.parseRecord(payload, "payId");
  }

  // for ProcessB, 
  public void initProcessB(GenericRecord payload) {
    crossId = (String) DataUtils.parseRecord(payload, "crossId");
    maxId = (String) DataUtils.parseRecord(payload, "maxId");
    minId = (String) DataUtils.parseRecord(payload, "minId");
  }