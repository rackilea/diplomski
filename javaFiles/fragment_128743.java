private static void processFile(Path filePath) {
    System.out.println(filePath);

    //Get the file name of the train set.
    String fileLocation = filePath.normalize().toString();
    String[] tokens = fileLocation.split("[\\\\|/]");
    String filename = tokens[tokens.length - 1];
    System.out.println("Train file:" + filename + " found!");

    //Get both the train and test set
    String TrainFile = "path/to/sets/Train/"+ filename;
    String TestFile = "path/to/sets/Test/"+ filename;

    //Load the train set
    Instances train = LoadARFF(TrainFile);
    train.setClassIndex(train.numAttributes() - 1);

    //Load the test set.
    Instances test = LoadARFF(TestFile);
    test.setClassIndex(train.numAttributes() - 1);

    //train classifier
    Classifier cls = new RandomForest();
    cls.buildClassifier(train);

    // evaluate classifier and print some statistics
    Evaluation eval = null;
    eval = new Evaluation(train);
    eval.evaluateModel(cls, test);
    System.out.println(cls);
    System.out.println(eval.toSummaryString("\nResults\n======\n", false));
}

private static void processPath(Path path) {
    if(Files.isRegularFile(path)) {
        try {
            processFile(path);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

public static void main(String[] args) throws Exception {     
    //Get all files from training path
    Files.walk(Paths.get("path/to/sets/Train")).forEach(Eval::processPath);
}//Main