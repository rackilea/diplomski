public static Stream<Obj> allObjs(Obj o) {
    if (o == null) return Stream.empty(); // in case the argument is null
    return Stream.concat(
            Stream.of(o), 
            o.getObjs() == null ?
                Stream.empty() :
                o.getObjs().stream().flatMap(ObjService::allObjs));
}

public static String deepToString(Obj o) {
    return ObjService.allObjs(o)
        .map(Obj::getobjId)
        .collect(Collectors.joining(", "));
}