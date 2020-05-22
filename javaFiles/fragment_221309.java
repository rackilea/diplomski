final Set<WarehouseAddressPosition> positions = 
  warehouse.
  getAddresses().
  stream().
  filter(a -> !Validator.isEmpty(a.getPositions())).
  flatMap(a -> a.getPositions().stream()).
  collect(Collectors.toSet());