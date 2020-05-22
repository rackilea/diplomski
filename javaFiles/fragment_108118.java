public class RungeKutta {

    public static double CoolingLaw(double time, double objectTemp)
         {
             double k = 0.19, ambientTemp = 70.0;     
             return -k * (objectTemp - ambientTemp);
         }

    public static void main(String[] args) {

        double result = 0.0;  
        double  objectTemp = 300.0;
        double dt = 0.1

        for(double t = 0.0; t <= 20.0; t += dt)
        {        
            double k1 = dt * CoolingLaw(t, objectTemp);
            double k2 = dt * CoolingLaw(t + (dt/2.0), objectTemp + (k1/2.0));
            double k3 = dt * CoolingLaw(t + (dt/2.0), objectTemp + (k2/2.0));
            double k4 = dt * CoolingLaw(t + dt, objectTemp + k3);
            objectTemp = objectTemp + (1.0/6.0) * (k1 + (2.0 * k2) + (2.0 * k3) + k4);
            result = objectTemp;
        }       
        System.out.println("The approx. object temp after 20 seconds is: " + result);

    }


}