private static final Moshi moshi = new Moshi.Builder()
        .add(MoshiRuntimeTypeJsonAdapterFactory.of(Shape.class)
                .with(Shape.Circle.class)
                .with(Shape.Diamond.class)
                .with(Shape.Rectangle.class)
        )
        .build();