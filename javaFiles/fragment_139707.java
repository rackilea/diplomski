class ElseWhereInTheUI {
    public ElseWhereInTheUI() {
        GlobalTimer.register(new GlobalTimerListener() {
            @Override
            public void onTick() {
                doTheThingThatHappensOnTick();
            }
        });
    }
    private void doTheThingThatHappensOnTick() {
        //...
    }
}