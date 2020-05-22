public class MyClass<E extends MyEntityClass> {
    public List<E> myList = new LinkedList<>();

    public MyClass(JsonArray params, Function<JsonElement, E> factoryE) {
        for(JsonElement param : params){
            myList.add(factoryE.apply(param));
        }
    }
}