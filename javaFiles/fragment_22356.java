public class ProvEngineConfig {
  private String bed_name;
  private String provisioned;
  private String connected;
  private String IP_Address;
  private String connection_error;
}

public class ProvNetworks {
  private String available;
  private Map<String, ProvSSID> SSIDs;  // Notice this is a map
}

public class ProveQuerySetting {
  ProvQueryData data;
  ProvQueryHeader header;
}

public class ProvQueryData {
  ProvEngineConfig engine_config;
  ProvNetworks networks;
}

public class ProvQueryHeader {
  String id;
  String filename;
  String sequence;
  String last_modified;
  String JSON_file_version;
}

public class ProvSSID {
  String SSID;
  String mac_address;
  String channel;
  String RSSI;
  String security;
  String security_type;
}