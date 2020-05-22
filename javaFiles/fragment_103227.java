this.people = FXCollections.observableArrayList();

 ListChangeListener<Person> listener = new ListChangeListener<Person>() {

    private boolean checkCondition(ObservableList<Person> list, Person.Gender gender) {
        int males = 0;
        int females = 0;

        for (Person person : list) {
            switch (person.getGender()) {
                case MALE: males++; break;
                case FEMALE: females++; break;
                default: break;
            }
        }

        return ((males > 10 && gender == Person.Gender.MALE) ||
                (females > 5 && gender == Person.Gender.FEMALE));
    }

    @Override
    public void onChanged(Change<? extends Person> c) {
        while (c.next()) {
            if (c.wasAdded()) {
                for (Person person : c.getAddedSubList()) {

                    if (checkCondition((ObservableList<Person>) c.getList(), person.getGender()))
                        c.getList().remove(person);
                    else
                        person.genderProperty().addListener((obs, oldval, newval) -> {
                            if (checkCondition((ObservableList<Person>) c.getList(), newval))
                                person.setGender(oldval);
                        });
                }
            }
        }
    }
};

people.addListener(listener);