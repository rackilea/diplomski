public class RainFall {

    public double[] rainfall;


    public RainFall(double[] a) {
        this.rainfall = a;
    }

    public double total() {
        double t = 0.0;
        for(int i = 0; i < rainfall.length; i++) {
            t += rainfall[i];
        }
        return t;
    }
    public double average() {
        double v = 0.0;
        double t = 0.0;
        for(int i = 0; i < rainfall.length; i++) {
            t += rainfall[i];
        }
        v = t/rainfall.length;
        return v;
    }
    public String most() {
        String months[]={"January", "February", "March", "April", "May", "June", "July", "August", "September",
                        "October", "November", "December"};
        int j = 0;
        int max = (int) rainfall[0];
        for(int i = 1; i < rainfall.length; i++) {
            if(rainfall[i] > max) {
                max = (int) rainfall[i];
                j = i;
            }
        }
        return months[j];
    }
    public String least() {
        String months[]={"January", "February", "March", "April", "May", "June", "July", "August", "September",
                        "October", "November", "December"};
        int j = 0;
        int min = (int) rainfall[0];
        for(int i = 1; i < rainfall.length; i++) {
            if(rainfall[i] < min) {
                min = (int) rainfall[i];
                j = i;
            }
        }
        return months[j];
    }
}