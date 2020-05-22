Timer timer = new Timer();
List<String> list = new List();
//repeat your timer
timer.scheduleAtFixedRate(new TimerTask() {
  @Override
  public void run() {
    //loop through the folder and get the names
    File folder = new File("your/path");
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        if(list.contains(listOfFiles[i].getName())
         {
             //already checked file
         }
      else
         {
             //new file add your move logic and add it to the list
             list.add(listOfFiles[i].getName());
         } 
      } 
    }
  }
}, 2*60*1000, 2*60*1000);