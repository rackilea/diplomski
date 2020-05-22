Aggregation aggregation = newAggregation(
     Aggregation.match(Criteria.where("id").is(new ObjectId("58e8da206ca4f710bab6ef74"))),
     Aggregation.project("name")
                 .and(ArrayOperators.Filter.filter("courses").as("course")                          
                 .by(ComparisonOperators.Eq.valueOf("course._id").equalToValue(new ObjectId("58d65541495c851c1703c57f")))
                    ).as("courses")
 );