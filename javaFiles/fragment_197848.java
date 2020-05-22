public void addPolicyBatch(SmbFile smbFile) throws Exception {
    BufferedReader br = null;
    try {
        SmbFileInputStream smbStream = new SmbFileInputStream(smbFile); 
        br = new BufferedReader(new InputStreamReader(smbStream)); 
        String line; 
        while((line = br.readLine()) != null){ 
        //....