SubActivity filter = new SubActivity();
filter.setDeadline(new Date());
filter.setCompleted(true);

List<Activity> activities = datastore.find(Activity.class)
                                              .field("listSubActivity")
                                              .hasThisElement(filter)
                                              .asList();