bind(new TypeLiteral<Map<ObjectType, Boolean>> {})
    .toInstance(ImmutableMaps.<ObjectType, Boolean>newBuilder()
        .add(Type1, TRUE)
        .add(Type2, TRUE)
        // [snip, you could replace with a for-loop or pre-built map]
        .build());

// Now you can inject "Map<ObjectType, Boolean>".