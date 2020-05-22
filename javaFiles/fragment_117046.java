@Override
public void configureCamel() {
    from("timer://fnzPoller?period=2000&delay=2000").processRef(UrlPingProcessor.class.getSimpleName())
           .processRef(StopStartProcessor.class.getSimpleName()).to("log://TimerPollingRoute?showAll=true");

}