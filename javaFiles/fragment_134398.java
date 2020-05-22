Map<Integer, List<Item>> map = new HashMap<>();

map.put(1, Arrays.asList(Item.of(0, "A"), Item.of(1, "B"), Item.of(1, "C")));
map.put(2, Arrays.asList(Item.of(0, "D"), Item.of(1, "E")));

List<Observable<Item>> emitter = new ArrayList<>();

for (List<Item> list : map.values()) {
    int time = 0;

    for (Item i : list) {
        time += i.duration;
        emitter.add(Observable.just(i).delay(time, TimeUnit.SECONDS));
    }
}

Observable.merge(emitter).map(v -> v.title)
.toBlocking()
.subscribe(System.out::println);