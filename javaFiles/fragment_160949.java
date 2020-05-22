import matlabcontrol.*;

public class TestMyFunc
{
    public static void main(String[] args)
        throws MatlabConnectionException, MatlabInvocationException
    {
        // create proxy
         MatlabProxyFactoryOptions options =
            new MatlabProxyFactoryOptions.Builder()
                .setUsePreviouslyControlledSession(true).build();
        MatlabProxyFactory factory = new MatlabProxyFactory(options);
        MatlabProxy proxy = factory.getProxy();

        // call function and get output cell array
        String in = "Stack Overflow";
        Object[] out = proxy.returningFeval("myfunc", 1, in);

        // extract stuff from cell array
        out = (Object[]) out[0];
        String str = (String) out[0];
        double x = ((double[]) out[1])[0];
        double[] arr = (double[]) out[2];

        // show result
        System.out.println("str =\n " + str);
        System.out.println("x = \n " + x);
        System.out.println("arr =");
        for(int i=0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
        }

        // shutdown MATLAB
        //proxy.feval("quit");

        // close connection
        proxy.disconnect();
    }
}