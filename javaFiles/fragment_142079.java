public GraphQLController(AgendamentoService agendamentos, ConfiguracaoService config, ProcessoService processos, ParametroService parametros, AuthenticationService autenticacao) {
    GraphQLSchema schema = new GraphQLSchemaGenerator()
            .withResolverBuilders(
                    //Resolve by annotations
                    new AnnotatedResolverBuilder())
            .withOperationsFromSingletons(agendamentos, config, processos, parametros, autenticacao)
            .withValueMapperFactory(new JacksonValueMapperFactory())
            .generate();
    graphQL = GraphQL.newGraphQL(schema).build();
}