double[][] data = {
                    {4058.0, 4059.0, ... }, /* first instance */
                    {19.0, 20.0, ... }      /* second instance */
                  };

int numAtts = data[0].length;
FastVector atts = new FastVector(numAtts);
for (int att = 0; att < numAtts; att++)
{
    atts.addElement(new Attribute("Attribute" + att, att));
}

int numInstances = data.length;
Instances dataset = new Instances("Dataset", atts, numInstances);
for (int inst = 0; inst < numInstances; inst++)
{
    dataset.add(new Instance(1.0, data[inst]));
}

BufferedWriter writer = new BufferedWriter(new FileWriter("test.arff"));
writer.write(dataset.toString());
writer.flush();
writer.close();