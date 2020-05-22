private RandomStringUUID uuid;

private createUuid() {
    uuid = new RandomStringUUID();  //Or any other way you create it
}

public static RandomStringUUID getRuuidForOtherClassesToCheck() {
    return ruuid;
}