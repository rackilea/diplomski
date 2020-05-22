static List<Function<Person,?>> EQ_PROPS=Arrays.asList(
    Person::getName, Person::getSurname, Person::getAge);

static BiPredicate<Person,Person> EQUAL=EQ_PROPS.stream()
    .<BiPredicate<Person,Person>>map(f -> (a,b) -> Objects.equals(f.apply(a), f.apply(b)))
    .reduce(BiPredicate::and).get();

static ToIntFunction<Person> HASH=EQ_PROPS.stream()
    .<ToIntFunction<Person>>map(f -> a -> Objects.hash(f.apply(a)))
    .reduce((f,g) -> x -> f.applyAsInt(x)*31+g.applyAsInt(x)).get();

@Override
public boolean equals(Object obj) {
    return obj==this || (obj instanceof Person)&& EQUAL.test(this, (Person)obj);
}
@Override
public int hashCode() {
    return HASH.applyAsInt(this);
}