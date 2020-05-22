import static org.mongodb.morphia.aggregation.Group.*;

Query<Activity> query = datastore.createQuery(Activity.class)
               .filter("listSubActivity.deadline < ", anyDate)
               .filter("listSubActivity.completed = ", true);

Iterator<Activity> activities = datastore.createAggregation(Activity.class).
               unwind("listSubActivity").
               match(query).
               group("_id", grouping("className", first("className")),
                       grouping("name", first("name")),
                       grouping("description", first("description")),
                       grouping("deadline", first("deadline")),
                       grouping("completed", first("completed")), grouping("listSubActivity", push("listSubActivity"))).aggregate(Activity.class);