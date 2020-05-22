private void doIt(List<Item> items, String strToFind) {
    items.stream()
         .flatMap(item -> item.strings.stream().unordered()
             .filter(str -> this.operation(str, strToFind)).limit(1)
             .map(string -> item.id + "-" + string))
         // example terminal operation
         .forEach(System.out::println);
}