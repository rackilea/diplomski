Policy bucket_policy = new Policy().withStatements(
new Statement(Statement.Effect.Allow)
    .withPrincipals(Principal.AllUsers)
    .withActions(S3Actions.GetObject)
    .withResources(new Resource(
        "arn:aws:s3:::" + bucket_name + "/*")));