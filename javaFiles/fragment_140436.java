public void writeConfig() throws Exception {
    Properties tempProp = new Properties();
    tempProp.load(new FileInputStream("app.config")); 
    tempProp.setProperty("x", "y,z");
    tempProp.store(new FileOutputStream("app.config"), null); 

  }