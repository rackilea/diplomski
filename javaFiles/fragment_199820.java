@Scheduled(fixedDelay =30000)
public void demoServiceMethod () {... }

@Scheduled(fixedRate=30000)
public void demoServiceMethod () {... }

@Scheduled(cron="0 0 * * * *")
public void demoServiceMethod () {... }