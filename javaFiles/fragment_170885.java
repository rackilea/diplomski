public class MyQueryPlugin extends Plugin implements SearchPlugin {

    @Override public List<QuerySpec<?>> getQueries() {
        return Arrays.asList(
                new QuerySpec<>("my_query", MyQueryBuilder::new, MyQueryBuilder::fromXContent)
        );
    }
}