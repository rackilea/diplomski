Bson addFields = addFields(new Field<Document>("dt", 
                                               new Document("$dateFromString", 
                                                            new Document("dateString", "$dt")
                                                                .append("format", "%d/%m/%Y")
                                                            )
));

List<Bson> pipeline = Arrays.asList(addFields, sort(descending("dt")), skip(2), limit(1));
List<Document> results = new ArrayList<>();
collection.aggregate(pipeline).into(results);

// The required MongoDB driver imports:
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Aggregates.addFields;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Aggregates.skip;
import static com.mongodb.client.model.Aggregates.sort;
import static com.mongodb.client.model.Sorts.descending;
import com.mongodb.client.model.Field;