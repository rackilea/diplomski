collection.aggregate(
    Arrays.asList(
       Aggregates.unwind("$planets", new UnwindOptions().preserveNullAndEmptyArrays(true)),
       Aggregates.group("$surfaceType",
            Accumulators.addToSet("planets", 
                new Document("radius", "$planets.radius")
                    .append("surfaceType", "$planets.surfaceType")
            )
        )
    )
);