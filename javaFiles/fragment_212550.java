// READER
while(true) {
    connect();

    // reload info from DB
    change_count=executeQuery("select change_count from change_counters where counter=foo");
    if(change_count> last_change_count){
      last_change_count=change_count;
      reload();
    }

    disconnect();
}