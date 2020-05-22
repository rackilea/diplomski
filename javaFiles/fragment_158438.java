import weka.classifiers.functions.SMOreg;
import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Tester {

    /**
     * Builds a regression model using SMOreg, the SVM for regression, and 
     * evaluates it with the Evalution framework.
     */
    public void buildAndEvaluate(String trainingArff, String testArff) throws Exception {

        System.out.printf("buildAndEvaluate() called.\n");

        // Load the training and test instances.
        Instances trainingInstances = DataSource.read(trainingArff);
        Instances testInstances = DataSource.read(testArff);

        // Set the true value to be the last field in each instance.
        trainingInstances.setClassIndex(trainingInstances.numAttributes()-1);
        testInstances.setClassIndex(testInstances.numAttributes()-1);

        // Build the SMOregression model.
        SMOreg smo = new SMOreg();
        smo.buildClassifier(trainingInstances);

        // Use Weka's evaluation framework.
        Evaluation eval = new Evaluation(trainingInstances);
        eval.evaluateModel(smo, testInstances);

        // Print the options that were used in the ML algorithm.
        String[] options = smo.getOptions();
        System.out.printf("Options used:\n");
        for (String option : options) {
            System.out.printf("%s ", option);
        }
        System.out.printf("\n\n");

        // Print the algorithm details.
        System.out.printf("Algorithm:\n %s\n", smo.toString());

        // Print the evaluation results.
        System.out.printf("%s\n", eval.toSummaryString("\nResults\n=====\n", false));
    }

    /**
     * Builds a regression model using SMOreg, the SVM for regression, and 
     * tests each data instance individually to compute RMSE.
     */
    public void buildAndTestEachInstance(String trainingArff, String testArff) throws Exception {

        System.out.printf("buildAndTestEachInstance() called.\n");

        // Load the training and test instances.
        Instances trainingInstances = DataSource.read(trainingArff);
        Instances testInstances = DataSource.read(testArff);

        // Set the true value to be the last field in each instance.
        trainingInstances.setClassIndex(trainingInstances.numAttributes()-1);
        testInstances.setClassIndex(testInstances.numAttributes()-1);

        // Build the SMOregression model.
        SMOreg smo = new SMOreg();
        smo.buildClassifier(trainingInstances);

        int numTestInstances = testInstances.numInstances();

        // This variable accumulates the squared error from each test instance.
        double sumOfSquaredError = 0.0;

        // Loop over each test instance.
        for (int i = 0; i < numTestInstances; i++) {

            Instance instance = testInstances.instance(i);

            double trueValue = instance.value(testInstances.classIndex());
            double predictedValue = smo.classifyInstance(instance);

            // Uncomment the next line to see every prediction on the test instances.
            //System.out.printf("true=%10.5f, predicted=%10.5f\n", trueValue, predictedValue);

            double error = trueValue - predictedValue;
            sumOfSquaredError += (error * error);
        }

        // Print the RMSE results.
        double rmse = Math.sqrt(sumOfSquaredError / numTestInstances);
        System.out.printf("RMSE = %10.5f\n", rmse);
    }

    public static void main(String argv[]) throws Exception {

        Tester classify = new Tester();
        classify.buildAndEvaluate("../weka-3-8-1/data/cpu.arff", "../weka-3-8-1/data/cpu.arff");
        classify.buildAndTestEachInstance("../weka-3-8-1/data/cpu.arff", "../weka-3-8-1/data/cpu.arff");
    }
}