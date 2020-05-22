public Optional<Pojo> parseJson(String json) {
    // Return an optional if there is risk for a null.
    return Optional.ofNullable(new Pojo());
}

private final IdMapper idMapper = new IdMapper();
private final Repo repo = new Repo();

public Mono<Pojo> query(long id) {

    // By returning an optional from the idMapper 
    // you can chain on and avoid null checks.
    return idMapper.getValue(id).map(integer -> repo.query(integer)
            .map(s -> parseJson(s).map(Mono::just)
                    .orElse(Mono.empty())))
            .orElse(Mono.error(() -> new NotFoundException("No Pojo with ID could be found")));
}

class Pojo {
    // Some pojo class
}

class Repo {
    public Mono<String> query(long id) {
        return Mono.just("Foo");
    }
}

class IdMapper {

    public Optional<Integer> getValue(long id) {
        // Here return an Optional instead of null!
        return Optional.of(1);
    }
}