@Autowired
public EventController(FirehosePutService firehosePutService) {
    this.firehosePutService = firehosePutService;

    Thread persister = new Thread(() -> {
        List<String> batchOfEvents = new ArrayList<>(batchSize);

        String next;
        while (( next = events.take()) != null) {
            batchOfEvents.add(value);

            if (batchOfEvents.size() == batchSize) {
                log.info("Consume {} elements. Size of batchOfEvents={}", consumed, batchOfEvents.size());
                firehosePutService.saveBulk(batchOfEvents);
                batchOfEvents.clear();
            }
        }
    });
    persister.start();

}