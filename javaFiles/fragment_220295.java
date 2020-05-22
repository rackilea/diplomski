static MapReader reader = null;

static Territory[][] missionMap = null;

static {  
   try { 

        reader = new MapReader("TutorialMap");
   } catch(FileNotFoundException e) { 
        e.printStackTrace();
   }
   missionMap = reader.getMap();

  }