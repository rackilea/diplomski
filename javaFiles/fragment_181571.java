and(context -> new BasicDBObject("$setIsSubset",
        Arrays.<Object> asList(
                Arrays.<Object> asList("584e6253e17ed10f0a8cba1d",
                         "583e9719e17e8c1bf80da2fe"),
                "$registered_users.user_id")))
.as("is_registered"));