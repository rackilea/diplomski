@Autowired
private AsyncInternalWrapper wrapper;

@Scheduled(fixedRate=1000)
public void publish() {
  ....

  wrapper.work(objsToPublish);
}