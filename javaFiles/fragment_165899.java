class Person {
    String name;
    String age;

    Person(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    enum TransformerFunctions implements Function<Person, String> {

        NAME_FUNCTION {
            @Override
            @Nullable
            public String apply(@Nullable Person person) {
                return person.getName();
            }
        },
        AGE_FUNCTION {
            @Override
            @Nullable
            public String apply(@Nullable Person person) {
                return person.getAge();
            }
        };
    }