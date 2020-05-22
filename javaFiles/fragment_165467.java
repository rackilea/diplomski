for (int i = 0; i < labeled.size(); i++) {
     double[] clsLabel = clf.distributionForInstance(newTest.instance(i));
     for(double d : clsLabel) {
         outFile.write(Double.toString(d));
     }
     outFile.write("\n");
}