private static final List<BiConsumer<Entity,Entity>> ACCESSORS =
    Collections.unmodifiableList(Array.asList(
        (src,dst) -> dst.setAreaCode(src.getAreaCode()),
        (src,dst) -> dst.setOtherProperty(src.getOtherProperty())
        /* etc */
));