import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Projections.computed;
import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;

Bson group = group(null,
    sum("followersCount", computed("$size",
        computed("$ifNull",
            asList("$followers", EMPTY_LIST)))),
    sum("followingCount", computed("$size",
        computed("$ifNull",
            asList("$i_am_following", EMPTY_LIST))))
);

AggregateIterable <Document> output = userinfo.aggregate(asList(group));