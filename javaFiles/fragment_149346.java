package org.encog.examples.neural.lunar;

import java.io.File;
import java.io.IOException;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationTANH;
import org.encog.ml.MLMethod;
import org.encog.ml.MLResettable;
import org.encog.ml.MethodFactory;
import org.encog.ml.ea.population.Population;
import org.encog.ml.genetic.MLMethodGeneticAlgorithm;
import org.encog.ml.genetic.MLMethodGenomeFactory;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.pattern.FeedForwardPattern;
import org.encog.util.obj.SerializeObject;

public class LunarLander {

    public static BasicNetwork createNetwork()
    {
        FeedForwardPattern pattern = new FeedForwardPattern();
        pattern.setInputNeurons(3);
        pattern.addHiddenLayer(50);
        pattern.setOutputNeurons(1);
        pattern.setActivationFunction(new ActivationTANH());
        BasicNetwork network = (BasicNetwork)pattern.generate();
        network.reset();
        return network;
    }

    public static void saveMLMethodGeneticAlgorithm(String file, MLMethodGeneticAlgorithm ga ) throws IOException
    {
        ga.getGenetic().getPopulation().setGenomeFactory(null);
        SerializeObject.save(new File(file),ga.getGenetic().getPopulation());   
    }

    public static MLMethodGeneticAlgorithm loadMLMethodGeneticAlgorithm(String filename) throws ClassNotFoundException, IOException {
        Population pop = (Population) SerializeObject.load(new File(filename));
        pop.setGenomeFactory(new MLMethodGenomeFactory(new MethodFactory(){
            @Override
            public MLMethod factor() {
                final BasicNetwork result = createNetwork();
                ((MLResettable)result).reset();
                return result;
            }},pop));

        MLMethodGeneticAlgorithm result = new MLMethodGeneticAlgorithm(new MethodFactory(){
            @Override
            public MLMethod factor() {
                return createNetwork();
            }},new PilotScore(),1);

        result.getGenetic().setPopulation(pop);

        return result;
    }


    public static void main(String args[])
    {
        BasicNetwork network = createNetwork();

        MLMethodGeneticAlgorithm train;


        train = new MLMethodGeneticAlgorithm(new MethodFactory(){
            @Override
            public MLMethod factor() {
                final BasicNetwork result = createNetwork();
                ((MLResettable)result).reset();
                return result;
            }},new PilotScore(),500);

        try {
            int epoch = 1;

            for(int i=0;i<50;i++) {
                train.iteration();
                System.out
                        .println("Epoch #" + epoch + " Score:" + train.getError());
                epoch++;
            } 
            train.finishTraining();

            // Round trip the GA and then train again
            LunarLander.saveMLMethodGeneticAlgorithm("/Users/jeff/projects/trainer.bin",train);
            train = LunarLander.loadMLMethodGeneticAlgorithm("/Users/jeff/projects/trainer.bin");

            // Train again
            for(int i=0;i<50;i++) {
                train.iteration();
                System.out
                        .println("Epoch #" + epoch + " Score:" + train.getError());
                epoch++;
            } 
            train.finishTraining();

        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int epoch = 1;

        for(int i=0;i<50;i++) {
            train.iteration();
            System.out
                    .println("Epoch #" + epoch + " Score:" + train.getError());
            epoch++;
        } 
        train.finishTraining();

        System.out.println("\nHow the winning network landed:");
        network = (BasicNetwork)train.getMethod();
        NeuralPilot pilot = new NeuralPilot(network,true);
        System.out.println(pilot.scorePilot());
        Encog.getInstance().shutdown();
    }
}