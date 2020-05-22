@Bean
@StepScope
ItemReader<NewsSync> filesReader() {
    return new NewsSyncReader(srcPath);
}

@Bean
@StepScope
ItemProcessor<NewsSync, NewsSync> newsProcessor() {
    return new NewsSyncProcessor(jdbcTemplate, newsRepository);
}

@Bean
@StepScope
ItemWriter<NewsSync> stateWriter() {
    return new NewsSyncWriter(jdbcTemplate);
}