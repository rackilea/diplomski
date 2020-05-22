public static void main(String [] argv) {
      try {
        Classifier cls = (Classifier) weka.core.SerializationHelper.read("bosom.100k.2.j48.MODEL");
        J48 c = (J48)cls;

        DataSource source = new DataSource("data.arff");
        Instances data = source.getDataSet();
        data.setClassIndex(6);        

        try {
            double outcomeValue = c.classifyInstance(data.instance(0));
            System.out.println("outcome "+outcomeValue);
            double[] p = c.distributionForInstance(data.instance(0));
            System.out.println(Arrays.toString(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }