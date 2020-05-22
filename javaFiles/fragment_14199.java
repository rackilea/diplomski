map1.values()
    .stream()
    .filter(e -> e instanceof Integer) // is this number an integer? if yes then you can pass else no
    .map(e -> (Integer)e) // map to integer so we can compare with '<' symbol
    .filter(e -> e < 5) 
    .forEach(System.out::println);