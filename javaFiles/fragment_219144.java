public Person(String firstName, String lastName) {
    this.firstName = new SimpleStringProperty(firstName);
    this.lastName = new SimpleStringProperty(lastName);

    this.nickName.bind(Bindings.createStringBinding(()->{
        if(this.firstName.get().length() > 2 && this.lastName.get().length() > 2) {
            return this.firstName.get().substring(0,3).concat(this.lastName.get().trim().substring(0,3));
        } else {
            return "";
        }
    }, this.firstName, this.lastName));

}