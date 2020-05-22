@Test
public Person[] combinePersons() throws Exception {
    CompletableFuture<Person> p1 = CompletableFuture.supplyAsync(() -> {
        return new Person("p1");
    });

    CompletableFuture<Person> p2 = CompletableFuture.supplyAsync(() -> {
        return new Person("p1");
    });

    // make sure not to change the contents of this array
    CompletableFuture<Person>[] persons = new CompletableFuture[] { p1, p2 };
    // this will throw an exception if any of the futures complete exceptionally
    CompletableFuture.allOf(persons).join();

    return Arrays.stream(persons).map(CompletableFuture::join).toArray(Person[]::new);
}