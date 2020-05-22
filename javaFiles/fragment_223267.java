private Stream<Obj> allObjs() {
    return Stream.concat(
        Stream.of(this), 
        objs == null ? Stream.empty() : objs.stream().flatMap(Obj::allObjs));
}

@Override
public String toString() {
    return allObjs()
        .map(Obj::getobjId)
        .collect(Collectors.joining(", "));
}