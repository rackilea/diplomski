import static com.mongodb.client.model.Accumulators.addToSet;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Projections.computed;
import static java.util.Arrays.*;

AggregateIterable<Document> output = collection.aggregate(asList(
       match(Filters.exists("val.elem.0001")),
       project(computed("FIELD_PATH","$val.elem.0001")),
       group( new Document("FIELD", new Document("$literal", "0001")), addToSet("PATH", "$FIELD_PATH"))));