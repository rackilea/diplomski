private void filterNaturalNo (ArrayList<model> models){
    ArrayList<model> filteredList = new ArrayList<>();
    for (model model: models){
        if (model.getNo() < 5 && model.getNo() > 1){
            filteredList.add(model);
        }
    }
    adapter.refreshAdapter(filteredList);
}