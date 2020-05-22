private static ThreadLocal<String> deviceId = new ThreadLocal<String>();

public static String getDeviceId() {
    return deviceId.get();
}

public static void setDeviceId(String newValue) {
    deviceId.set(newValue);
}