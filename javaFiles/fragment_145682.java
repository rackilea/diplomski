HashMap<String, Object> deviceSyncMap = new HashMap<>();
deviceSyncMap.put("fieldName1", 0);
deviceSyncMap.put("fieldName2", null);
deviceSyncMap.put("fieldName3", timestamp);

apiService.updateDeviceCurfewSync(deviceId, deviceSyncMap)