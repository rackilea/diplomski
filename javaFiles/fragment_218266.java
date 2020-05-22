private DataKey(Builder builder) {
    this.userId = builder.userId;
    this.uuid = builder.uuid;
    this.deviceid = builder.deviceid;
    this.clientId = builder.clientId;
    this.timeout = builder.timeout;

    if (userId == 0 && uuid == 0 && deviceId == 0) {
        throw new IllegalStateException("You have to pass at least one" +
          " of the following: userId, uuid or deviceId");
    }
    if (userId != 0) {
        this.flow = FlowEnum.USERFLOW;
    }
    else {
        this.flow = FlowEnum.DEVICEFLOW;
    }
}