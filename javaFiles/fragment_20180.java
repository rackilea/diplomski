package utils;

public class ServerCounter {

private static ServerCounter INSTANCE = new ServerCounter();
private final AtomicLong counter;

private ServerCounter() {
     //load value from file, do you need help by it?
     long value = this.loadCounterFromFile();
     counter = new AtomicLong(value);
};

private long loadCounterFromFile(){
    BufferedReader br = null;
    try {
        //no problem if there is no file, we will return 0 in this case
        br = new BufferedReader(new FileReader("C:\\Test\\counter.txt"));

        String line = br.readLine();
        if(line != null && line.length() > 0)
             return Long.parseLong(line);
        return 0;

     //catch all exceptionse, because we could get NumberFormatException or FileNotFound from parseLong
     } catch (Exception e) {
         return 0;
     } finally {
    try {
        if (br != null)br.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
 }
}

public static ServerCounter getInstance() {
         return INSTANCE;
    }
public String nextval() { return String.valueOf(counter.incrementAndGet()); }



//will be executed by listener
public void writeToFile(){
    //write the counter to file
    writeToFile(counter.get());
}
private void writeToFile(long value){
    try{
            //you need folder c:\Test, file will be created automatically if there is no file, it will override the old file
    BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Test\\counter.txt"));
            //need "" to create String
    bw.write("" + value);
    bw.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

}