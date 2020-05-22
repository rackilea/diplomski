public interface BaseBuilder<T, B extends BaseBuilder<T,B> {
    B add(String field, String value);

    default B person(String firstName, String lastName) {
        // This chaining is only possible thanks to that recursive parameter
        return add("firstName", firstName).add("lastName", lastName);
    }

    T build();

    default T buildPerson(String firstName, String lastName) {
        return person(firstName, lastName).build();
    }
}