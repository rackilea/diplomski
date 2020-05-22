Person person = new Person();
person.firstName = firstNameTextField.getText();
person.lastName = lastNameTextField.getText();
people.add(person);

person = new Person(); // <-- reinitializing person.
person.firstName = firstNameTextField.getText();
person.lastName = lastNameTextField.getText();
people.add(person);