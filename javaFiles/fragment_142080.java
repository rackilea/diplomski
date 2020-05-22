public GraphQLController(AgendamentoService agendamentos, ConfiguracaoService config, ProcessoService processos, ParametroService parametros, AuthenticationService autenticacao) {
    GraphQLSchema schema = new GraphQLSchemaGenerator()
            .withOperationsFromSingletons(agendamentos, config, processos, parametros, autenticacao)
            .generate();
    graphQL = GraphQL.newGraphQL(schema).build();
}