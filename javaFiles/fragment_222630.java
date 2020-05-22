import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.ArrayOperators.Filter.filter;
import static org.springframework.data.mongodb.core.aggregation.BooleanOperators.And.and;
import static org.springframework.data.mongodb.core.aggregation.ComparisonOperators.Eq;

 Aggregation agg = newAggregation(project().
     and(
      filter("workLogs").
      as("workLog").
      by(
       and(
          Eq.valueOf("workLog.month").equalToValue(1), 
          Eq.valueOf("workLog.year").equalToValue(2017)
      )
     )
    ).as("workLogs").
    andExclude("_id")
 );