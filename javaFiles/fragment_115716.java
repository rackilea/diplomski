public void setLeastUsedProxy() throws Exception {
    Database db = new Database();

    ArrayList<Integer> allProxies = db.getAllProxies();
    ArrayList<Integer> allAssignedProxies = db.getAssignedProxies();

    ArrayList<Integer> unusedProxies = allProxies;
    unusedProxies.removeAll(allAssignedProxies);

    // assign the unused proxy
    if (unusedProxies.size() > 0) {

    } else {
      Integer leastUsedProxy = db.getLeastUsedProxy();
      System.out.println(leastUsedProxy);
    }

  }