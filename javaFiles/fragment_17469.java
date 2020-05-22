// Untested Java, I use Weka through JRuby
NaiveBayes naiveBayes = new NaiveBayes();
Remove remove = new Remove();
remove.setOptions(Utils.splitOptions("-R 1-2"));
FilteredClassifier model = new FilteredClassifier(naiveBayes, remove);

// Use model to classify as normal