Configuration mapConf = context.getConfiguration();

URI[] cacheURIArray = DistributedCache.getCacheFiles();

String file2Location = mapConf.get("file2Location");

List<String> fileWords = new ArrayList<String>(); //set this as a clas variable so it can be accessed outside of the setup method of the mapper

for(URI uri: cacheURIArray){
    if( uri.toString().matches(".*"+fileLocation)){
        BufferedReader br = new BufferedReader(new InputStream(cacheFileSystem.open(new Path(uri.toString()))));
        String line = "";
        line = br.readLine();
        while(line != null){
            fileWords.add(line);
            line = br.readLine();
        }
    }
}