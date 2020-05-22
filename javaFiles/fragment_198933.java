public static void classify() {      
    try {            
        Instances train = new Instances (...);            
        train.setClassIndex(train.numAttributes() - 1);         
        Instances test = new Instances (...);            
        test.setClassIndex(test.numAttributes() - 1);                      
        ClassificationType classificationType = ClassificationTypeDAO.get(6);  // 6 is SVM.        
        LibSVM classifier = new LibSVM();
        String options = (classificationType.getParameters());
        String[] optionsArray = options.split(" ");                          
        classifier.setOptions(optionsArray);        
        classifier.buildClassifier(train);        
        Evaluation eval = new Evaluation(train);
        eval.evaluateModel(classifier, test);
        System.out.println(eval.toSummaryString("\nResults\n======\n", false));       
    } 
    catch (Exception ex) {            
        Misc_Utils.printStackTrace(ex);
    }                       
}