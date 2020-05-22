ChoiceBox<User> choiceBox =  new ChoiceBox<>(getUsers()); 
    // from your snippet, AdminSQL already returns the list as
    // an ObservableList, so you can set it directly as provided
    // new ChoiceBox<>(sql.getAllUsers()); 
StringConverter<User> converter = new StringConverter<>() {

    @Override
    public String toString(User user) {
        return user != null ? user.getUserLogin() : "";
    }

    @Override
    public User fromString(String userLogin) {
        // should never happen, choicebox is not editable
        throw new UnsupportedOperationException("back conversion not supported from " + userLogin);
    }

};
choiceBox.setConverter(converter);