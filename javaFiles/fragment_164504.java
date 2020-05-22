public class UserElasticsearchRepositoryImpl implements UserElasticsearchRepositoryCustom {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void updateAddress(User user, String updatedAddress){
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.source("address", updatedAddress);
        UpdateQuery updateQuery = new UpdateQueryBuilder().withId(user.getId()).withClass(User.class).withIndexRequest(indexRequest).build();
        elasticsearchTemplate.update(updateQuery);
    }
}