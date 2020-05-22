List<CoreLabel> classifiedLabels = classifier.classify(sentences);
CRFCliqueTree<String> cliqueTree = classifier.getCliqueTree(classifiedLabels);

for (int i = 0; i < cliqueTree.length(); i++) {
    CoreLabel wi = classifiedLabels.get(i);
    for (Iterator<String> iter = classifier.classIndex.iterator(); iter.hasNext();) {
        String label = iter.next();
        int index = classifier.classIndex.indexOf(label);
        double prob = cliqueTree.prob(i, index);
        System.out.println("\t" + label + "(" + prob + ")");
    }
    String tag = StringUtils.getNotNullString(wi.get(CoreAnnotations.AnswerAnnotation.class));
    System.out.println("Class : " + tag);
}