public void filterByType(Device[] devices, DeviceValueExtractor extractor, Object expect) {
    if (devices == null) {
        return;
    }
    for (int i = 0; i < devices.length; i++) {
        if (devices[i] == null) {
            continue;
        }
        Object actual = extractor.extractValue(devices[i]);
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