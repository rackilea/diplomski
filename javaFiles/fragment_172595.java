/**
 * The {@link org.springframework.integration.channel.PublishSubscribeChannel} {@link #channel}
 * method specific implementation to allow the use of the 'subflow' subscriber capability.
 * @param publishSubscribeChannelConfigurer the {@link Consumer} to specify
 * {@link PublishSubscribeSpec} options including 'subflow' definition.
 * @return the current {@link IntegrationFlowDefinition}.
 */
public B publishSubscribeChannel(Consumer<PublishSubscribeSpec> publishSubscribeChannelConfigurer) {