//Learning
DataSource source = new DataSource(Path);
Instances data = source.getDataSet();
J48 tree = new J48();
tree.buildClassifier(data);

//Evaluation
Evaluation eval = new Evaluation(data);
eval.evaluateModel(tree, data);
System.out.println((eval.correct()/data.numInstances())*100);