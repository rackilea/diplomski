Bson addFields = addFields(new Field<>("cmp", new Document("$or", asList(new Document("$eq", asList(1, 1))))));
Bson match = match(eq("cmp", true));
AggregateIterable aggregationQuery = collection.aggregate(asList(
               [...]
               addFields,
               match
));