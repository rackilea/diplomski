Aggregation aggregation = newAggregation(
        match(Criteria.where("_id").in(ids)),
        unwind("$attendees"),
        match(Criteria.where("attendees.reminded").is(false)),
        project("_id","attendees.contact.email"),
        group("_id").push("attendees.contact.email").as("emails")
    );