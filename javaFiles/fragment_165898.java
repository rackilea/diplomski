class NameFunction implements Function<Person, String> {

    @Override
    @Nullable
    public String apply(@Nullable Person person) {
            return person.getName();
    }
 }