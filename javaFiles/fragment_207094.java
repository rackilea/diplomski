public class Subject extends Observable{

    private int temperature;
    private int dayInTime;
    private int season;

    private void changeEnvironment() {
        Random random = new Random();
        this.season = SEASON[random.nextInt(3)];
        this.dayInTime = DAY_IN_TIME[random.nextInt(2)];
        this.temperature = random.nextInt(120);
        setChanged();

         /** Notify all of the subscribed observers about its changes
          It will call each observers' update(this, null)***/
        notifyObservers();
    }


    public int getTemperature(){....}
    public int getdayInTime(){.....}
    public int getSeason(){....}

}