class Device {
    // will be validated in the controller
    private String status;
    // getter, setter, etc
}

// with:

public enum DeviceStatus {
    ACTIVE, INACTIVE, DELETED, ARCHIVED;
}