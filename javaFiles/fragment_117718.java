channelMetadataDetails =
    channelMetadataDetails.stream()
                          .filter(cm -> cm.getId() != null || cm.getUnitOfMeasureId() != null || cm.getMeasureTypeId() != null)
                          .filter(cm -> cm.getId() == null || cm.getId().equals("2"))
                          .filter(cm -> cm.getUnitOfMeasureId() == null || cm.getUnitOfMeasureId().equals("4"))
                          .filter(cm -> cm.getMeasureTypeId() == null || cm.cm.getMeasureTypeId().equals("5"))
                          .collect(Collectors.toList());