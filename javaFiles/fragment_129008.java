public RefReplicatedDataProcessor(){
    //this is what didn't work         
    if (custkey.contains(",")) {
        String[] ck = custkey.split(",");
        for ( String k : ck) {
            this.loadRefDb(k);
        }
    } else {
        this.loadRefDb(custkey);
    }
}