public ArrayList<Double[]>  ec;
public double[][]           ei;
...
encogCorpus = new ArrayList<Double[]>();
...
ec.add(inputs);
...
ei = new double[ec.size()][];

for (int i = 0; i < ec.size(); i++) {
    // Changes are only below here

    Double[] row = ec.get(i);
    double[] copy = new double[row.length];

    // Still, manually loop...
    for (int j = 0; j < row.length; j++) {
        copy[j] = row[j];
    }

    ei[i] = copy;
}