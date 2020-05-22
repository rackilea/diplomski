List<ObjectDTOHelper> helpers = ...; //about 1000 elements
int size = helpers.size();

List<String> ids= helpers.stream().map(h -> h.id).collect(toCollection(()->new ArrayList<>(size)));
List<Date> times= helpers.stream().map(h -> h.time).collect(toCollection(()->new ArrayList<>(size)));
List<String> names= helpers.stream().map(h -> h.name).collect(toCollection(()->new ArrayList<>(size)));
List<String> details= helpers.stream().map(h -> h.detail).collect(toCollection(()->new ArrayList<>(size)));

new ObjectDTO(ids, times, name, detail)