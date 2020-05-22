final long count = Stream.of("Cristian","Daniel","Ortiz","Cuellar")
  .filter(new Predicate<String>() {
       public boolean test(String s) {
          return matcher(s).find();
       }
   })
  .count();