public static <T> void filterByType(Device[] devices, Function<Device, T> extractor, T expect) {
    if (devices == null) {
        return;
    }
    for (int i = 0; i < devices.length; i++) {
        if (devices[i] == null) {
            continue;
        }
        Object actual = extractor.apply(devices[i]);
        if (actual == null && expect== null) {
            continue;
        } else if (actual  == null) {
            devices[i] = null;
            continue;
        }
        if (!Objects.equals(actual, expect)) {
            devices[i] = null;
        }
    }
}