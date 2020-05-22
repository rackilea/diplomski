final Configuration hornetConfig = new ConfigurationImpl();
// other configuration...

final AddressSettings addressSetting = new AddressSettings();
addressSetting.setMaxSizeBytes(10 * 1024 * 1024); // 10 MB
addressSetting.setPageSizeBytes(1024 * 1024);     // 1 MB

final Map<String, AddressSettings> addressing = new HashMap<String, AddressSettings>();
addressing.put("#", addressSetting); // the # pattern matches all addresses
hornetConfig.setAddressesSettings(addressing);