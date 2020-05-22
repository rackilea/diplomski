public class Foo {

private static IAuditLogRepository iAuditLogRepository;

@Autowired
private IAuditLogRepository iaRepos;

@PostConstruct
public void someFunction () {
iAuditLogRepository = iaRepos;
}


public static int saveLog(LogFile logFile){
iAuditLogRepository.saveLog(logFile); 
}


}