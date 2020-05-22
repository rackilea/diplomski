@Component
public class ImportTimerTask extends TimerTask {

    @Autowired
    private ImportService importService;

    @Override
    public void run() {
        importService.startImport();
    }
}