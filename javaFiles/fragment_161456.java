ObservableList<Part> search(String sub, ObservableList<Part> full) {
    ObservableList<Part> result = FXCollections.observableArrayList();
    for (Part part : full) {
        if (part.getPartName().contains(sub)) {
            result.add(part);
        }
    }
    return result;
}