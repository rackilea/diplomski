public static void main(String args[]){

            int i =0;
            int j=0;
            double[] stations = {10,20,30};
            for(i=0;i<stations.length;i++){
                for(j=i+1;j<stations.length;j++){
                 System.out.println("distance between station "+i+" and station "+j+" is "+ (stations[j] - stations[i]));   
                }               
            }
}