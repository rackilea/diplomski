public void afterPropertiesSet() {
        List<Object> customConverters = new ArrayList<Object>();
        customConverters.add(new UuidToDBObjectConverter());
        customConverters.add(new DBObjectToUUIDConverter());
        customConverters.add(new MessageHistoryToDBObjectConverter());
        customConverters.add(new DBObjectToGenericMessageConverter());
        customConverters.add(new DBObjectToMutableMessageConverter());
        DBObjectToErrorMessageConverter docToErrorMessageConverter = new DBObjectToErrorMessageConverter();
        if (MongoDbMessageStore.this.whiteListPatterns != null) {
            docToErrorMessageConverter.deserializingConverter
                    .addWhiteListPatterns(MongoDbMessageStore.this.whiteListPatterns);
        }
        customConverters.add(docToErrorMessageConverter);
        customConverters.add(new DBObjectToAdviceMessageConverter());
        customConverters.add(new ThrowableToBytesConverter());
        this.setCustomConversions(new CustomConversions(customConverters));
        super.afterPropertiesSet();
    }