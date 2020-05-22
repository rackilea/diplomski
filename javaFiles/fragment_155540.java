package my.maxent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import opennlp.maxent.GIS;
import opennlp.maxent.io.GISModelReader;
import opennlp.maxent.io.SuffixSensitiveGISModelWriter;
import opennlp.model.AbstractModel;
import opennlp.model.AbstractModelWriter;
import opennlp.model.DataIndexer;
import opennlp.model.DataReader;
import opennlp.model.FileEventStream;
import opennlp.model.MaxentModel;
import opennlp.model.OnePassDataIndexer;
import opennlp.model.PlainTextFileDataReader;

public class MaxentTest {


    public static void main(String[] args) throws IOException {

        String trainingFileName = "training-file.txt";
        String modelFileName = "trained-model.maxent.gz";

        // Training a model from data stored in a file.
        // The training file contains one training sample per line.
        DataIndexer indexer = new OnePassDataIndexer( new FileEventStream(trainingFileName)); 
        MaxentModel trainedMaxentModel = GIS.trainModel(100, indexer); // 100 iterations

        // Storing the trained model into a file for later use (gzipped)
        File outFile = new File(modelFileName);
        AbstractModelWriter writer = new SuffixSensitiveGISModelWriter((AbstractModel) trainedMaxentModel, outFile);
        writer.persist();

        // Loading the gzipped model from a file
        FileInputStream inputStream = new FileInputStream(modelFileName);
        InputStream decodedInputStream = new GZIPInputStream(inputStream);
        DataReader modelReader = new PlainTextFileDataReader(decodedInputStream);
        MaxentModel loadedMaxentModel = new GISModelReader(modelReader).getModel();

        // Now predicting the outcome using the loaded model
        String[] context = {"is_VBZ", "Gaby_NNP"};
        double[] outcomeProbs = loadedMaxentModel.eval(context);

        String outcome = loadedMaxentModel.getBestOutcome(outcomeProbs);
        System.out.println("=======================================");
        System.out.println(outcome);
        System.out.println("=======================================");
    }

}