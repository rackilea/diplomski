RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("RootQuery")
                        .dataFetcher("RedditAPI", new DataFetcher() {
                            @Override
                            public Object get(DataFetchingEnvironment dataFetchingEnvironment) {
                                return RedditAPI.newBuilder().build();
                            }
                        })
                )
                .type(newTypeWiring("RedditAPI")
                        .dataFetcher("users", usersDataFetcher)
                        .dataFetcher("subreddits", subredditsDataFetcher)
                )
                .build();