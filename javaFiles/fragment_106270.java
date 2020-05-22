AggregationOperation project = Aggregation.project().
         and("Contrat").nested(Fields.fields("Field1","Field2")).
         and("Formule").nested(Fields.fields("Field3","Field4"));
AggregationOperation project2 = Aggregation.project().
         and("Contrats").nested(Fields.fields("Contrat","Formule")).
AggregationOperation out = Aggregation.out("test");

Aggregation aggregation = Aggregation.newAggregation(project, project2, out);
mongoTemplate.aggregate(aggregation, "<nameOfInitialCollection>", Class.class);