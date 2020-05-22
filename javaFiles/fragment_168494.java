private static GraphQLFieldDefinition allTodoes=
    GraphQLFieldDefinition
      .newFieldDefinition()
      .name("allTodoes")
      .type(new GraphQLList(todo))
      .argument(skip)
      .argument(take)
      .dataFetcher(fetcher)
      .build();