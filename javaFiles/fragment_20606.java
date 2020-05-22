public static void moveTo(final Coordinate destination) {

    changeState(State.NAVIGATION);
    controlPnl.addRemote(Remote.createRemote(remoteType.NAVIGATION));

    new Thread(new Runnable() {
                   public void run() {
                       dmc.moveTo(destination);
                       changeState(State.IMMEDIATE);
                       controlPnl.addRemote(Remote.createRemote(remoteType.IMMEDIATE));
                   }
               }).start();
}