IModel<String> textModel = new AbstractReadOnlyModel<String>() {
    public String getObject() {
        return added ? getString("removeFav") : getString("addFav");
    }
};
new Button("favButton", textModel) { };