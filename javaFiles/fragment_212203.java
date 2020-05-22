public class ApplicationService {

    private ApplicationDao applicationDao;
    private DerogationService derogationService;
    private LogService logService;
    private static ApplicationService applicationServiceInstance;

    private ApplicationService() 
    {
        applicationDao = ApplicationDao.getInstance();
        //I don't do it there 
        //derogationService = DerogationService.getInstance();
        logService = LogService.getInstance();
    }

    public static synchronized ApplicationService getInstance(){
        if(applicationServiceInstance == null)
        {
            applicationServiceInstance = new ApplicationService();
            // But here, so i won't get this loop problem.
            applicationServiceInstance.derogationService = DerogationService.getInstance();
        }
        return applicationServiceInstance;
    }