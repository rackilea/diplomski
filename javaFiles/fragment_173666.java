private void doIt(List<Item> items, String strToFind) {
    items.stream()
         .flatMap(item -> item.strings.stream()
             .filter(str -> this.operation(str, strToFind))
             .map(string -> item.id + "-" + string).findAny().stream())
         // example terminal operation
         .forEach(System.out::println);
}