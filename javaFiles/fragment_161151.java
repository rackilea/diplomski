public class Dose {
   public static void main(String... args) {
     double[][] arr = new double[][] {
                    {0.0,1.0,3.0},
                    {2.0,55.0,8.0},
                    {98.0,9.0,67.0},
                    {7.0,-1.0,22.0}
                    };
     double dose=0.0;
     int maxPosition=0;
     int counter = 0;
     for(double[] tarr:arr)
     {
        for(double aval:tarr) {
           counter++;
           if (Double.compare(aval,dose) > 0) {
              dose=aval;
              maxPosition=counter;
           }
        }
     }
     System.out.println("Maximum value: "+dose);
     System.out.println("Max value position: "+maxPosition);
     System.out.println("Arr length: "+arr.length);
     System.out.println("Sub Arr length: "+arr[0].length);
     System.out.println("Row:"+((maxPosition/arr.length)+1) +
                        " Column:"+(maxPosition%arr[0].length==0?arr[0].length:maxPosition%arr[0].length));
   }
}