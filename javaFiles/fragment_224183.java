checkbox.addValueChangeListener(click -> {
    changeIsAnwesend(u, grid);
});

....

private void changeIsAnwesend(User user, Grid grid) {
    user.setAnwesend(!user.isAnwesend());
    //grid.setSelectionMode(Grid.SelectionMode.SINGLE).select(user);
    userRepository.save(user);

    // reload data from DB
    ListDataProvider<User> dataProvider = DataProvider.ofCollection(userRepository.findAll());
    grid.setDataProvider(dataProvider);

    // or in short form (it will do the same):
    // grid.setItems(userRepository.findAll());
}