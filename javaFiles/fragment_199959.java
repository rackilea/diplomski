empInfos.stream()
    .filter(empInfo -> empInfo.getStreetNumber() != null)
    .forEach(empInfo -> addressInfos.stream()
        .filter(addressInfo -> addressInfo.getStreetNumber() != null && addressInfo.getStreetNumber().longValue() == empInfo.getStreetNumber().longValue())
        .forEach(addressInfo -> {
          empInfo.setStreetName(addressInfo.getStreetName());
          empInfo.setStreetZipCode(addressInfo.getStreetZipCode());
        }));