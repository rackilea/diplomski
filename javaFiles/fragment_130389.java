//The dataFetcher used to fetch a board object.
    DataFetcher boardDataFetcher() {
        return environment -> {
            Object board = new Object() {
                String name = "board Name";
            };
            return board;
        };
    }
    //Your deffinition of what a board type contains/what of the board type you want to expose
    public GraphQLObjectType boardType = newObject()
            .name("boardType")
            .field(newFieldDefinition()
                    .name("name")
                    .type(GraphQLString)
            )
            .build();
    // Define your query types 
    public GraphQLObjectType queryType = newObject()
            .name("Query")
            .field(newFieldDefinition()
                    .name("board")
                    .type(boardType)
            )
            .build();

    // wire the query, board and datafetcher together
    public GraphQLCodeRegistry codeRegistry = newCodeRegistry()
            .dataFetcher(
                    coordinates("Query", "board"), boardDataFetcher()
            )
            .build();
    //create the schema
    GraphQLSchema graphQLSchema = GraphQLSchema.newSchema()
            .query(queryType)
            .codeRegistry(codeRegistry)
            .build();