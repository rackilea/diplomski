public static class Person {

    private final StringProperty firstname = new SimpleStringProperty();
    private final StringProperty lastname = new SimpleStringProperty();
    private final ReadOnlyStringWrapper fullName = new ReadOnlyStringWrapper();

    public Person(String firstname, String lastname) {
        this.firstname.set(firstname);
        this.lastname.set(lastname);
        fullName.bind(Bindings.concat(firstname, " ", lastname));
    }

    public static final ObservableList<Person> createDemoList() {
        final ObservableList<Person> result = FXCollections.observableArrayList();
        result.add(new Person("Paul", "McCartney"));
        result.add(new Person("Andrew Lloyd", "Webber"));
        result.add(new Person("Herb", "Alpert"));
        result.add(new Person("Emilio", "Estefan"));
        result.add(new Person("Bernie", "Taupin"));
        result.add(new Person("Elton", "John"));
        result.add(new Person("Mick", "Jagger"));
        result.add(new Person("Keith", "Richerds"));
        return result;
    }

    public final StringProperty firstnameProperty() {
        return this.firstname;
    }

    public final java.lang.String getFirstname() {
        return this.firstnameProperty().get();
    }

    public final void setFirstname(final String firstname) {
        this.firstnameProperty().set(firstname);
    }

    public final StringProperty lastnameProperty() {
        return this.lastname;
    }

    public final String getLastname() {
        return this.lastnameProperty().get();
    }

    public final void setLastname(final String lastname) {
        this.lastnameProperty().set(lastname);
    }

    public final ReadOnlyStringProperty fullNameProperty() {
        return this.fullName.getReadOnlyProperty();
    }

    public final String getFullName() {
        return this.fullNameProperty().get();
    }

    @Override
    public String toString() {
        return getFullName(); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.firstname);
        hash = 79 * hash + Objects.hashCode(this.lastname);
        hash = 79 * hash + Objects.hashCode(this.fullName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(getFirstname(), other.getFirstname())) {
            return false;
        }
        if (!Objects.equals(getLastname(), other.getLastname())) {
            return false;
        }
        return Objects.equals(this.getFullName(), other.getFullName());
    }

}