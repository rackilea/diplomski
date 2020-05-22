private Map<String, Boolean> changeMap = new HashMap<>();
//in your selectedItem listener
if (newValue.equals("")) {
    changeMap.remove(item);
} else {
    changeMap.put(item, true);
}
//before setGraphic(cb)
if(changeMap.contains(item)) {
    cb.setStyle("-fx-background-color: transparent; -fx-border-color: green;");
}