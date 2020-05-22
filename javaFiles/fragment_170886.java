public class MyQueryPlugin extends Plugin implements SearchPlugin {

    @Override
    public List<QuerySpec<?>> getQueries() {
        return Arrays.asList(new QuerySpec<>(
                "my_query",
                new Writeable.Reader<MyQueryBuilder>() {
                    @Override
                    public MyQueryBuilder read(StreamInput in) throws IOException {return new MyQueryBuilder(in);}
                },
                new QueryParser<MyQueryBuilder>() {
                    @Override
                    public Optional<MyQueryBuilder> fromXContent(QueryParseContext parseContext) throws IOException {return MyQueryBuilder.fromXContent(parseContext);}
                })
        );
    }
}