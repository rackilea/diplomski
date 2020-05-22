try {
    Timer timer = new Timer(true);
    TimerTask interruptTimerTask = new InterruptTimerTask(Thread.currentThread());
    timer.schedule(interruptTimerTask, howLongDoYouWantToWait);
    rMIinstance.ping();
    timer.cancel();
} catch (RemoteException | InterruptedException e) {
    getInstanceRegister().removeInstance(rMIinstance);
}