StringChanger sc = new StringChanger() {
     @Override
     public String change(String o) {
         return o.trim();
     }
 };
 Stream.of("hello", "world")
       .map(sc::change)
       .forEach(System.out::println);