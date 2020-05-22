@Bean
public ThreadPoolTaskScheduler getScheduler(){
    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    scheduler.setPoolSize(10);
    return scheduler;
}