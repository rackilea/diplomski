File logFileFolder = new File("logs");
File stalkerFolder = new File("plugins/Stalker");
File logFile = new File("logs/logFile.txt");
FileWriter fw;
FileReader fr;
BufferedWriter writer;
BufferedReader reader;

public void someMethod(){
    System.out.println(logFile.getAbsolutePath());
    try{
        if (!logFileFolder.exists()){
             // Create folder if does not exist
             logFileFolder.mkdir();
        }
        logFile.createNewFile();
    }catch(Exception e){
        System.err.println("WARNING: CANNOT CREATE FILE");
    }
    try{
        if (!stalkerFolder.exists()){
             // Create folders if does not exist
             stalkerFolder.mkdirs();
        }
        fw = new FileWriter("plugins/Stalker/log.txt");
        fr = new FileReader("plugins/Stalker/log.txt");
        writer = new BufferedWriter(fw);
        reader = new BufferedReader(fr);
    } catch(Exception e){
        System.err.println("ERROR: CANNOT READ OR WRITE TO LOG FILE");
    }
}