public ArrayList<ArrayList<Double>> ec;  // line changed here
public double[][]                   ei;
...
encogCorpus = new ArrayList<ArrayList<Double>>(); // and here also
...
ec.add(inputs); // `inputs` here should be of type `ArrayList<Double>`
...
ei = new double[ec.size()][];

for (int i = 0; i < ec.size(); i++) {
    ArrayList<Double> row = ec.get(i);

    // Perform equivalent `toArray` operation
    double[] copy = new double[row.size()];
    for (int j = 0; j < row.size(); j++) {
        // Manually loop and set individually
        copy[j] = row.get(j);
    }

    ei[i] = copy;
}