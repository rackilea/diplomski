//Declaring attributes
    Attribute PT1 = new Attribute("PT1");
    Attribute w1 = new Attribute("w1");
    Attribute d1 = new Attribute("d1");
    Attribute PT2 = new Attribute("PT2");
    Attribute w2 = new Attribute("w2");
    Attribute d2 = new Attribute("d2");

    // Declare the class attribute along with its values contains two nominal values yes and no using FastVector. "ScheduledFirst" is the name of the class attribute        
    FastVector fvClassVal = new FastVector(2);
    fvClassVal.addElement("yes");
    fvClassVal.addElement("no");
    Attribute Class = new Attribute("ScheduledFirst", fvClassVal);

    // Declare the feature vector
    FastVector fvWekaAttributes = new FastVector(7);
    // Add attributes 
    fvWekaAttributes.addElement(PT1);
    fvWekaAttributes.addElement(w1);
    fvWekaAttributes.addElement(d1);
    fvWekaAttributes.addElement(PT2);
    fvWekaAttributes.addElement(w2);
    fvWekaAttributes.addElement(d2);
    fvWekaAttributes.addElement(Class);
    // Declare Instances which is required since I want to use classification/Prediction
    Instances dataset = new Instances("whatever", fvWekaAttributes, 0);

    //Creating a double array and defining values
    double[] attValues = new double[dataset.numAttributes()];
    attValues[0] = 50;
    attValues[1] = 5;
    attValues[2] = 800;
    attValues[3] = 74;
    attValues[4] = 3;
    attValues[5] = 760;

    //Create the new instance i1
    Instance i1 = new Instance(1.0, attValues);
    //Add the instance to the dataset (Instances) (first element 0)        
    dataset.add(i1);
    //Define class attribute position
    dataset.setClassIndex(dataset.numAttributes()-1);

    //Will print 0 if it's a "yes", and 1 if it's a "no"
    System.out.println(tree.classifyInstance(dataset.instance(0)));
    //Here I call dataset.instance(0) since there is only one instance added in the dataset, if you do add another one you can use dataset.instance(0), etc.