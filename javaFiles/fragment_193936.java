ArrayList<Model> modelList = new ArrayList<>();
modelList.add(new Model("chandru"));
modelList.add(new Model("mani"));
modelList.add(new Model("vivek"));
modelList.add(new Model("david"));

Collections.sort(modelList, new Comparator<Model>() {
    @Override
    public int compare(Model lhs, Model rhs) {
        return lhs.getName().compareTo(rhs.getName());
    }
});