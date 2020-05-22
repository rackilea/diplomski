Set<String> lines;
public void configure(JobConf job){
    lines = new HashSet<>();

    BufferedReader SW;
    try {
        localFiles = DistributedCache.getLocalCacheFiles(job);      
        SW = new BufferedReader(new FileReader(localFiles[0].toString()));
        lines.add(SW.readLine());            
        SW.close();
    } catch (FileNotFoundException e) {
        System.err.println(e.toString());
    } catch (IOException e) {
        System.err.println(e.toString());
    }       
}