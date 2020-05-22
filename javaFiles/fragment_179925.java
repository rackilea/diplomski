import weka.core.Instances;
 import weka.classifiers.Evaluation;
 import weka.classifiers.trees.J48;
 ...
 Instances train = ...   // from somewhere
 Instances test = ...    // from somewhere
 // train classifier
 Classifier cls = new J48();
 cls.buildClassifier(train);
 // evaluate classifier and print some statistics
 Evaluation eval = new Evaluation(train);
 eval.evaluateModel(cls, test);
 System.out.println(eval.toSummaryString("\nResults\n======\n", false));