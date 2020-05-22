GraphQLTemplate graphQLTemplate = new GraphQLTemplate();

InputObject resizeInput = new InputObject.Builder()
  .put("width", 512)
  .put("height", 288)
  .put("background", "ffffff")
  .build();

GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
    .url("https://domain/graphql")
    .arguments(
        new Arguments("exercise.images", new Argument("resize", resizeInput))
    )
    .request(Exercise.class)
    .build();