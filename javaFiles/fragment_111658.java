class Array2DCollector implements Collector<String, Map<Integer,String>, String[][]>{

    private final AtomicInteger index = new AtomicInteger(0);

    @Override
    public Supplier<Map<Integer, String>> supplier(){
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Integer, String>, String> accumulator(){
        return (map, string) -> map.put(index.getAndIncrement(), string);
    }

    @Override
    public BinaryOperator<Map<Integer, String>> combiner(){
        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<Integer, String>, String[][]> finisher(){
        return map -> {
            final String[][] array = new String[index.get()][2];
            for(int i = 0; i < map.size(); i++){
                array[i][0] = String.valueOf(i);
                array[i][1] = map.get(i);
            }
            return array;
        };
    }

    @Override
    public Set<Characteristics> characteristics(){
        return EnumSet.noneOf(Characteristics.class);
    }
}