import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

Aggregation agg = Aggregation.newAggregation(
        match(Criteria.where("mobile").is("1234567890")), // <-- missing closing parenthesis
        group("mobile").sum("calls").as("totalCalls"),
        project("totalCalls")
    );

AggregationResults<Doc> results = mongoTemplate.aggregate(agg, "yoCollection", Doc.class);
Doc doc = results.getMappedResults().get(0);