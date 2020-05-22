public List<DVD> displayDVDsInCategory(String category) {
    List<DVD> result = new ArrayList<>();
    for (int i = 0; i < arraylist.size(); i++) {
        if(category.equalsIgnoreCase(arraylist.get(i).getCategory())) {
           result.add(arraylist.get(i));
        }
    }
    return result;
}