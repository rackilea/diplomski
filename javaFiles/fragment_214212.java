public class FooJsonSimplifiedSerializationWrapper extends Foo {
    @JsonGetter("fooList")
    public List<Integer> serializeFooList() {
        return this.getFooList().stream().map(f -> f.getId()).collect(Collectors.toList());
    }

    public static List<FooJsonSimplifiedSerializationWrapper> convertFromFoo(List<Foo> fooList) {
        return fooList.stream().map(f -> {
            FooJsonSimplifiedSerializationWrapper fooSimplified = new FooJsonSimplifiedSerializationWrapper();
            BeanUtils.copyProperties(f, fooSimplified);

            return fooSimplified;

        }).collect(Collectors.toList());
    }
}