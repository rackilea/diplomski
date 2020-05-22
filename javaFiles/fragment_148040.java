// make sure not to change the contents of this array
CompletableFuture<Person>[] persons = new CompletableFuture[] { p1, p2 };
CompletableFuture.allOf(persons).thenAccept(ignore -> {
   for (int i = 0; i < persons.length; i++ ) {
       Person current = persons[i].join();
   }
});