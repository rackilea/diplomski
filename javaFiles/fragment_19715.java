for (Location location : locations) {
  List<?> newList = location.getSubList().stream()
                                         .filter(this::correctTestDataValue)
                                         .collect(Collectors.toList());
  location.setSubList(newList);
}