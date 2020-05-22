private boolean findIdInTheList(List<String> ids, String id) {
    String theId = ids.stream()
                      .filter(elem -> id.equals(elem))
                      .findAny()
                      .orElse(null);
}