import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static java.util.Arrays.asList;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

Bson match = match(and(ne("DOCRANK", 0), ne("TAB", "People-Tab")));
Bson group = group("$USERID", first("USERID", "$USERID"), first("DOCID", "$DOCID"), first("DOCRANK", "$DOCRANK"), first("QUERYTEXT", "$QUERYTEXT"));
Bson projection = project(fields(include("USERID", "DOCID", "DOCRANK", "QUERYTEXT"), excludeId()));
MongoCursor<Document> cursor = collection.aggregate(asList(match, group, projection)).iterator();