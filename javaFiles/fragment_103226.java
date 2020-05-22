this.people = FXCollections.observableArrayList(person -> new Observable[] {person.genderProperty()});

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
                }
            }
            if (c.wasUpdated()) {
                for (int update = c.getFrom(); update < c.getTo(); update++) {
                    Person person = c.getList().get(update);
                    if (checkCondition((ObservableList<Person>) c.getList(), person.getGender()))
                        person.setGender(Person.Gender.UNKNOWN);
                }

            }
        }
    }
};

people.addListener(listener);