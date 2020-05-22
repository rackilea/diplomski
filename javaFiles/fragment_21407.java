@Bean
public IntegrationFlow testFlow() {
    return IntegrationFlows
        .from(TEST_CHANNEL).fixedSubscriberChannel()
        .channel(TEST_UPPER_CHANNEL)
        .channel(TEST_LOWER_CHANNEL)
        .get();
}