@Bean
@InboundChannelAdapter(value = "executionMessageFileInputChannel",
        poller = @Poller(fixedDelay = "20000", maxMessagesPerPoll = "1"))
public MessageSource<File> fileMessageSource(@Value("${fpml.messages.input}") File directory) {
    FileReadingMessageSource fileReadingMessageSource = new FileReadingMessageSource();
    fileReadingMessageSource.setDirectory(directory);
    fileReadingMessageSource.setFilter(new SimplePatternFileListFilter("*.xml"));
    return fileReadingMessageSource;
}