final AddressSettings addressSetting = new AddressSettings();
addressSetting.setMaxSizeBytes(10 * 1024 * 1024); // 10 MB
addressSetting.setPageSizeBytes(1024 * 1024);     // 1 MB

server.getPagingManager().getPageStore(new SimpleString(addressName))
                         .applySetting(addressSetting);