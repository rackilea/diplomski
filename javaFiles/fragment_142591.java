lastDeviceEvent = deviceEvents
                .stream()
                .filter (o -> o.getDeviceId().equals(deviceId)) // Original code used getId()
                .sorted(comparing((DeviceEvent de) -> de.getId()).reversed())
                .findFirst()
                .get();