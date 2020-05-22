List<Map.Entry<String,Integer>>entries=...
Map<String,Collection<Map.Entry<String,Integer>>>map=Multimaps.index(entries,new GroupFunction()).asMap();

class GroupFunction implements Function<Map.Entry<String,Integer>, String> {
    @Override
    public String apply(Map.Entry<String,Integer>input) {
        return input.getKey();
    }
}