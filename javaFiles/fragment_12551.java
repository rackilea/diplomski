@Scheduled(cron="0 * * * * *")
public void doScheduledWork() {
    for (PlayerResources pr: findAllPlayerResources()) {
        // pr has to know how to find its player
        pr.setMetal(calculateNewMetalValueForGivenPlayer(pr)); 
        update(pr)    
    }
}