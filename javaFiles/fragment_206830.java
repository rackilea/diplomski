Query<SubActivity> query = datastore.createQuery(SubActivity.class)
        .filter("deadline < ", new Date())
        .filter("completed = ", true);

List<Activity> activities = datastore.find(Activity.class)
                                              .field("listSubActivity")
                                              .elemMatch(query)
                                              .asList();