nameCol.setCellValueFactory(features -> {
  var firstName = features.getValue().firstNameProperty();
  var lastName  = features.getValue().lastNameProperty();
  var nickname  = features.getValue().nicknameProperty();

  return Bindings.when(nickname.isEmpty())
      .then(firstName.concat(" ").concat(lastName))
      .otherwise(nickname);
});