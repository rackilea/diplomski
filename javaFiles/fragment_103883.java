GetResponse getResponse;

  public synchronized void setRunning(GetResponse response) {
       this.getResponse = response;
  }

  public synchronized void run() {

       getResponse = elasticClient
            .prepareGet("elastestdb", "elastestdb", "id1" ).execute()
            .actionGet();

       System.out.println(source);
  }