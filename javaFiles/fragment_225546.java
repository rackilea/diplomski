@Component
public class ImagesPurgeJob implements Job {

    private Logger logger = Logger.getLogger(this.getClass());

    @Value("${jobs.mediafiles.imagesPurgeJob.enable}")
    private boolean imagesPurgeJobEnable;

    @Override
    @Transactional(readOnly=true)
    @Scheduled(cron = "${jobs.mediafiles.imagesPurgeJob.schedule}")
    public void execute() {

         //Do something
        //can use DAO or other autowired beans here
        if(imagesPurgeJobEnable){

            Do your conditional job here...

        }
    }
}