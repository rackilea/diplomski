public class Bicycle {

    private int bike;
    private int gear;
    private int cadence;

    public int getGear() {
        return gear;
    }    
    public void setGear(int gear) {
        if (gear >= 1 && gear <= 3) {
            this.gear = gear;
        }
    }

    public int getCadence() {
        return cadence;
    }
    public void setCadence(int cadence) {
        if (cadence >= 1 && cadence <= 100) {
            this.cadence = cadence;
        }
    }

    public double getSpeed() {
        if (gear == 1) {
            return cadence / 12.0;
        } else if (gear == 2) {
            return cadence / 6.0;
        } else if(gear == 3{
            return cadence / 4.0;
        }else{
            return 0;
        }
    }
}