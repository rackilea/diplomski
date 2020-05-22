@Bean(destroyMethod="")
public ItemReader<MyTable> cetFileReader(EntityManagerFactory entityManagerFactory) {
    JpaPagingItemReader<MyTable> itemReader = new JpaPagingItemReader<MyTable>();
    itemReader.setEntityManagerFactory(entityManagerFactory);
    itemReader.setQueryString("select mt from MyTable mt where status in ('1','2','3')");
    itemReader.setPageSize(1000);
    return itemReader;
}