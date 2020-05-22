RuntimeWiring buildRuntimeWiring() {
    return RuntimeWiring.newRuntimeWiring()
            // this uses builder function lambda syntax
            .type("Query", typeWiring -> typeWiring
                    .dataFetcher("students", env -> fetchDataSomeHow(env)))             
            .build();
}