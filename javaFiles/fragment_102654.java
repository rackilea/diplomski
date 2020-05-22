File resolveFileName(){
    String directory ="C:/Users/user/Desktop/";

    File res = new File(directory + "test.csv");
    if(!res.exists()){
        return res;
    }
    int filesInDirectoryCount = (new File(directory)).listFiles().length;
    String fileName = "test_"+filesInDirectoryCount+".csv";
    return new File(directory+fileName);
}