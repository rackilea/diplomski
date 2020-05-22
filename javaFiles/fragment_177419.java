public class LogAnalyzer() {

private int[]hourCounts;
private LogfileReader reader;

    // version that accepts LogFileReader
    public LogAnalyzer(LogfileReader r){
        hourCounts=new int[24];
        reader=r; // use the passed LogfileReader object, instead of creating one
    }

    // no-argument version
    public LogAnalyzer(){
        hourCounts=new int[24];
        reader=new LogfileReader();
    }

}