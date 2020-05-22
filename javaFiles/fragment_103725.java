Collectors.toMap(
    Function.identity(), 
    String::length, 
    (u, v) -> {
        throw new IllegalStateException(String.format("Duplicate key %s", u));
    }, 
    LinkedHashMap::new
)