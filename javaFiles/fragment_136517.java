@Bean
MongoDbMessageStore messageStore() {
    return new MongoDbMessageStore(mongoDbFactory);
}

...

.messageStore(messageStore())