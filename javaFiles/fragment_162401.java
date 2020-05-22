class MyTime {
    private int minutes;
    private int hours;
    //Make this public if you think you'll need it.
    private MyTime(int h, int m) {
       this.hours = h;
       this.minutes = m;
    }

    public int getMinutes() { return minutes; }
    public int getHours() { return hours; }

    public static MyTime AddTime(int h, int m, int elapsedHours, int elapsedMinutes) {
        m += elapsedMinutes;         //add minutes
        h += elapsedHours + (m/60);  //add hours + the possible hour from minutes. integer truncation here is good. 61/60 = 1
        m = m%60;                    //get rid of excess minutes. 60 becomes 0, 61 becomes 1, etc...
        return new MyTime(h, m);
    }

    //I'm not sure if this will compile.
    /*
    public static int[2] AddTimeWeird(int h, int m, int elapsedHours, int elapsedMinutes) {
        MyTime myTime = AddTime(h, m, elapsedHours, elapsedMinutes);
        int time[] = new int[2];
        time[0] = myTime.getHours();
        time[1] = myTime.getMinutes();
        return time;
    }
    */
}