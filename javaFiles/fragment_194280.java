Map<String, String> map = new HashMap<String, String>();
    map.put("deviceid", "00:11:7F:54:DF:0B");
    map.put("features", "0x2a7f");
    map.put("model", "AndroidTV2,1");
    map.put("srcvers", "130.14");
    ServiceInfo info = ServiceInfo.create(
            "tt@AppleTV._airplay._tcp.local",
            "tt@AppleTV", 46667,1,1,false, map);