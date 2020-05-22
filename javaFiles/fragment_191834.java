@Resource
private TimerService timerService;

@Timeout
public void run() {
    DayPlanning planning = getPlanning();
    Order order = planning.getNextInLine();
    if(order instanceof Order) {
        em.merge(planning);
        List<String> tests = new ArrayList();
        for(Test test : order.getTests()) {
            tests.add(test.getName());
        }

        TestmachineSender.orderTests(order.getId(), order.getDomain(), tests);

        // if the checker handler doesn't need to run transactionally you could leave it like it was before
        timer.schedule(checker, safetycheckAt());
        // otherwise you could create a checker EJB that uses @Timeout in the same manner or @Scheduled from EJB3.1
    } else {
        // postpone timer
        timerService.createTimer(postponeTo(), "postponed timer information");    
    }
}

@PostConstruct
public void init() {
    if(getPlanning().hasActiveTest()) {
        timerService.createTimer(computeDelay(), "timer information");
        // or you could use the other create methods of the timerService, those that fits your needs better
    }
}