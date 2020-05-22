public Optional<A> getItems(List<String> items){
    return items.stream()
         .map(s -> new B())
         .findFirst()
         .map(Function.identity());
}