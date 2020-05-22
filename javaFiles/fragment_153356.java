List<Person> persins = Arrays.asList( new Person("Bob", "Smith", "R."));

assertThat(persons, contains(anyOf(
      sameProprtyValues(new Person("Bob", "Smith", "R.")),
      sameProprtyValues(new Person("Alex", "Black", "T.")) 
));