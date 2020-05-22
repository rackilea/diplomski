import weka.classifiers.Classifier;
import weka.core.Instances;

public class Main {

    public static void main(String[] args) throws Exception
    {
        String rootPath="/some/where/"; 
        Instances originalTrain= //instances here

        //load model
        Classifier cls = (Classifier) weka.core.SerializationHelper.read(rootPath+"tree.model");

        //predict instance class values
        Instances originalTrain= //load or create Instances to predict

        //which instance to predict class value
        int s1=0;

        //perform your prediction
        double value=cls.classifyInstance(originalTrain.instance(s1));

        //get the prediction percentage or distribution
        double[] percentage=cls.distributionForInstance(originalTrain.instance(s1));

        //get the name of the class value
        String prediction=originalTrain.classAttribute().value((int)value); 

        System.out.println("The predicted value of instance "+
                                Integer.toString(s1)+
                                ": "+prediction); 

        //Format the distribution
        String distribution="";
        for(int i=0; i <percentage.length; i=i+1)
        {
            if(i==value)
            {
                distribution=distribution+"*"+Double.toString(percentage[i])+",";
            }
            else
            {
                distribution=distribution+Double.toString(percentage[i])+",";
            }
        }
        distribution=distribution.substring(0, distribution.length()-1);

        System.out.println("Distribution:"+ distribution);
    }

}