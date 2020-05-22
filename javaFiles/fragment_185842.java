enum Flow {
    USERFLOW , DEVICEFLOW 
}
private String toLocalPook(Flow f) {
    String prefix = "";
    if (f.equals(Flow.DEVICEFLOW)) {
        prefix = "/testdevice";
    } else if (f.equals(Flow.USERFLOW)) {
        prefix = "/test";
    }
    if (this == DEV) {
        return prefix + "/datacenter/dc1";
    }

    return prefix + "/datacenter/" + name().toLowerCase();
}