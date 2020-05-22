public Iterable<Mono<MyObject>> getMultipleObjects(ArrayList<String> endpoints) {
    ArrayList<Mono<MyObject>> monos = new ArrayList<Mono<MyObject>> ();
    for (String endpoint: endpoints) {
         monos.add(getOneObject(endpoint));
    }
    return monos;
}