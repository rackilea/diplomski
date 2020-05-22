public static final int NUM_ELEMENTS = 100_000;

public static void main(String[] args) {
    //init
    ArrayDeque<Obj> source = new ArrayDeque<>(NUM_ELEMENTS);
    ArrayDeque<Obj> destination = new ArrayDeque<>(NUM_ELEMENTS);

    for(int i = 0; i < NUM_ELEMENTS; i++) {
        source.add(new Obj("" + i));
    }

    //modify
    source.stream()
            .map(obj -> obj.modify(" V2"))
            .forEach(obj -> destination.add(obj));

    source.clear();

    //print
    destination.stream()
            .forEach(obj -> System.out.println(obj.getProperty()));
}