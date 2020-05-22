public class ReadWorkJob {

    private WorkJobRepository workJobRepository;

    @Autowired
    public ReadWorkJob (WorkJobRepository workJobRepository) {
        this.workJobRepository = workJobRepository;
    }

    public void writeNewIdData(JSONObject jsonObject) {
        WorkJob workJob = getExistingId(jsonObject.get("id").toString());
    }

    private WorkJob getExistingId(String id) {
        logger.info("check point ppppp");
        WorkJob workJob = workJobRepository.findById(id);
        logger.info("check point qqqqq");
        return workJob != null ? workJob : new WorkJob();
    }
}