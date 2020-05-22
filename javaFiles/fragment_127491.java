@Bean
public MessageChannel messageStoreBackedChannel() {
    return new QueueChannel(
        new MessageGroupQueue(<<MessageStoreImplementation>>, "Group ID")
    );
}