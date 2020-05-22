setModel(new DefaultSingleSelectionModel() {

    @Override
    public void setSelectedIndex(int index) {
        System.out.println("woah!");
    }
});