import java.rmi.*;

public class IntegralClient
{
    public static void main(String[] args) 
    {
        try 
        {
            IntegralComputeEngineInterface integralCounter = (IntegralComputeEngineInterface) Naming.lookup("rmi://localhost/integral");
            double result = integralCounter.computeIntegral(createFunction(), -1, 1);
            System.out.println("Result is: " + result);
        } 
        catch (Exception e) 
        {
            System.out.println("HelloClient exception: " + e);
        }
    }

    private static Function createFunction() throws RemoteException 
    {
//      return new FunctionInterface()
//      {
//          @Override
//          public double valueIn(double x) 
//          {
//              return 1-x;
//          }
//      };

        return new Function();
    }
}