package org.mongodb.morphia;
import com.mongodb.MongoClient;
import org.mongodb.morphia.aggregation.AggregationPipeline;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.mongodb.morphia.aggregation.Accumulator.accumulator;
import static org.mongodb.morphia.aggregation.Group.*;
import static org.mongodb.morphia.aggregation.Projection.projection;
import static org.mongodb.morphia.query.Sort.descending;

public class MorphiaClient {
    public static void main(String[] args) {
        final Morphia morphia = new Morphia();
        morphia.mapPackage("org.mongodb.morphia");
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
        AggregationPipeline pipeline = datastore.createAggregation(Input.class).
                project(projection("id"), projection("title")).
                group(id(grouping("titleLetter", accumulator("$substr", Arrays.asList("$title", 0, 1)))),
                        grouping("count", accumulator("$sum", 1)),
                        grouping("shows", accumulator("$push", "title"))).
                sort(descending("id"));
        List<Output> results = new ArrayList<>();
        Iterator<Output> iterator = pipeline.aggregate(Output.class);
        while (iterator.hasNext()) {
            results.add(iterator.next());
        }
    }
}