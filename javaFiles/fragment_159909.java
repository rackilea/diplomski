public interface StreamOpenCollector<T> extends Collector<T, Object, Stream<T>> {   
    static <T> Collector<T, Object, Stream<T>> onOpen(Object arg, Consumer<Object> consumer){
        return Collectors.collectingAndThen(Collectors.toList(), (list) -> {
            consumer.accept(arg);
            return list.stream();
        });
    }   
}