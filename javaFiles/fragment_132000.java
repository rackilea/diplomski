class RainFall{
     private double minFall;
     private double maxFall;
    public void setMinFall(double minFall) {
        this.minFall = minFall;
    }
    public double getMinFall() {
        return minFall;
    }
    public void setMaxFall(double maxFall) {
        this.maxFall = maxFall;
    }
    public double getMaxFall() {
        return maxFall;
    }

}
public class RainFallMeasure{
        public static void main(String[] args) {
     Map<Integer,RainFall> rainFalls=new HashMap<Integer,RainFall>();
     RainFall janRainFall = new RainFall();
     janRainFall.setMinFall(1);
     janRainFall.setMaxFall(1.6);
     rainFalls.put(Calendar.JANUARY, janRainFall);
     RainFall febRainFall = new RainFall();
     ...
     rainFalls.put(Calendar.FEBRUARY, febRainFall);
    }
}