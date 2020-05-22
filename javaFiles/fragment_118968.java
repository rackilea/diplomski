import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instances;

public class AttTest {

    public static void main(String[] args) throws Exception
    {
        double[] one={0,1,2,3};
        double[] two={3,2,1,0};
        double[][] both=new double[2][4];
        both[0]=one;
        both[1]=two;

        Instances to_use=AttTest.buildArff(both);
        System.out.println(to_use.toString());
    }

  public static Instances buildArff(double[][] array) throws Exception
  {
         FastVector      atts = new FastVector();
         atts.addElement(new Attribute("lat")); //latitude
         atts.addElement(new Attribute("lon")); //longitude

         // 2. create Instances object
         Instances test = new Instances("location", atts, 0);

         // 3. fill with data
         for(int s1=0; s1 < array[0].length; s1=s1+1)
         {
             double vals[] = new double[test.numAttributes()];
             vals[0] = array[0][s1];
             vals[1] = array[1][s1];
             test.add(new DenseInstance(1.0, vals));
         }

         return(test);
  }
}