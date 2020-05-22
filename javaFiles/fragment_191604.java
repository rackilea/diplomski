@Bean
public Step getLCBOStoreDataStep(final LCBOStoreReader lcboStoreReader,
                                 final LCBOStoreProcessor lcboStoreProcessor,
                                 final LCBOStoreWriter lcboStoreWriter,
                                 final ExecutionContextPromotionListener listener) throws Exception {

    return stepBuilderFactory
            .get("getLCBOStoreDataStep")
            .<LCBOStore, LCBOStore>chunk(inventoryTrackerProperties.getDefaults().getChunkSize())
            .reader(lcboStoreReader.read())
            .processor(lcboStoreProcessor)
            .writer(lcboStoreWriter)
            .listener(listener)
            .build();
}