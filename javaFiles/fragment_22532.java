package wekaExamples.loadDatasetExamples;

import weka.core.Instances;
import weka.core.converters.*;

import java.io.*;


/**
 * Created by atilla.ozgur on 17.12.2014.
 */
public class LoadCsvExample {

    public static void main(String[] args) {
        System.out.println("loading training data");

        Instances instances = null;
        try {
            String fileName = "./data/deneme1.csv";

            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(fileName));
            instances = loader.getDataSet();

        } catch (Exception e) {
            e.printStackTrace();

            return;
        }
        System.out.println("training data loaded");

        // Make the last attribute be the class
        instances.setClassIndex(instances.numAttributes() - 1);

        // Print header and instances.
        System.out.println("\ndataset:\n");
        System.out.println(instances);
    }

}