public class demo {
    public demo() throws Exception {
        // TODO Auto-generated constructor stub
        BufferedReader breader = null;
        breader = new BufferedReader(new FileReader(
                "D:/logiciels/weka-3-7-12/weka-3-7-12/data/iris.arff"));
        Instances Train = new Instances(breader);
        //Train.setClassIndex(Train.numAttributes() - 1); // comment out this line
        SimpleKMeans kMeans = new SimpleKMeans();
        kMeans.setSeed(10);
        kMeans.setPreserveInstancesOrder(true);
        kMeans.setNumClusters(3);
        kMeans.buildClusterer(Train);
        int[] assignments = kMeans.getAssignments();
        int i = 0;
        for (int clusterNum : assignments) {
            System.out.printf("Instance %d -> Cluster %d", i, clusterNum);
            i++;
        }
        breader.close();
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        new demo();
    }
}