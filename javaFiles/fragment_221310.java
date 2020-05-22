final Set<WarehouseAddressPosition> positions = 
  warehouse.
  getAddresses().
  stream().
  filter(a -> if (!Validator.isEmpty(a.getPositions())) {
                final Set<WarehouseAddressPosition> positions = new HashSet<WarehouseAddressPosition>(
                  a.getPositions());
                if (a.getPositions().size() > positions.size()) {
                  throw new FieldDuplicatedException("position error");
                } else {
                  return true;
                }
              } else {
                return false;
              }).
  flatMap(a -> a.getPositions().stream()).
  collect(Collectors.toSet());