ArrayList<Attribute> attributes = new ArrayList<Attribute>();
attributes.add(new Attribute("x"));
attributes.add(new Attribute("y"));
attributes.add(new Attribute("z"));

Instances dataRaw = new Instances("TestInstances", attributes , 0);
dataRaw.setClassIndex(dataRaw.numAttributes() - 1); // Assuming z (z on lastindex) as classindex 

for (Double[] a: myValues) {
    dataRaw.add(new DenseInstance(1.0, a));
}

// Then train or build the algorithm/model on instances (dataRaw) created above.

MultilayerPerceptron mlp = new MultilayerPerceptron(); // Sample algorithm, go through about neural networks to use this or replace with appropriate algorithm.
mlp.buildClassifier(dataRaw);

// Create a test instance,I think you can create testinstance without
// classindex value but cross check in weka as I forgot about it.

double[] values = new double[]{-818.84, 9186.82, 2436.73}; // sample values
DenseInstance testInstance = new DenseInstance(1.0, values);
testInstance.setDataset(dataRaw); // To associate with instances object

// now you can clasify
double classify = mlp.classifyInstance(testInstance);