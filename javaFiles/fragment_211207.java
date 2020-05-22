Bson username = Filters.type("username", BsonType.STRING);
    Bson email = Filters.regex("email", "@*.*$");
    Bson password = Filters.type("password", BsonType.STRING);

    Bson validator = Filters.and(username, email, password);

    ValidationOptions validationOptions = new ValidationOptions()
                                          .validator(validator);
    database.createCollection("accounts", new CreateCollectionOptions()
                                          .validationOptions(validationOptions));