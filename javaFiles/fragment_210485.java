public class Sun {
    private double M = 356.0470 + 0.9856002585 * PlanetVariableCalculations.getd2();
    private double w =  282.9404 +  4.70935e-5 * PlanetVariableCalculations.getd2();

    public void SunmCalculation(Double longtitude) {
        if (M < 0) {
            while (M < 0) {
                M = M + 360;
            }

        } else if (M > 360) {
            while (M > 360) {
                M = M - 360;
            }
        }

        double L = w + M;
        SunSidereal(L, longtitude);
    }

    private void SunSidereal(Double L, Double longtitude){
        double Ls = L;
        double RAhours = 300;
        double GMST0 = Ls/15 +12;
        double SIDTIME = GMST0 + UTCValues.getutcComplete() + longitude / 15;
        double HA = SIDTIME - RAhours;

        System.out.println("This is SIDTIME:" + SIDTIME);
        System.out.println("This is HA:" + HA);
        System.out.println("This is the longitude: " + Longitude  );
    }
}