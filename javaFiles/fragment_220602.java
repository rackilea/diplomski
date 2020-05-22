for (String monthName : map.keySet()) {
    ArrayList<Model> modelArray = map.get(monthName);
    //now do whatever your view pager needs to do with this Model and its fields
    for (Model model : modelArray) {
        String price = model.getPrice(); //if you have a getter
        String product = model.product; //if the field is public
    }
}