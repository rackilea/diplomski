//Get File
    reader = new BufferedReader(new FileReader(path + "/ArffFile.arff"));

    //Get the data
    Instances data = new Instances(reader);
    reader.close();

    //Setting class attribute
    data.setClassIndex(data.numAttributes() - 1);

    //Make tree
    J48 tree = new J48();
    String[] options = new String[1];
    tree.buildClassifier(data);

    //Print tree
    System.out.println(tree);