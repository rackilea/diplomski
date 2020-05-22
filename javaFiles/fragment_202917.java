public class Messages {

  public static class ProcessFiles{
    public final List<String> fileNames;
    public ProcessFiles(List<String> fileNames){
      this.fileNames = fileNames;
    }
  }

  public static class ProcessLine{
    public final String line;
    public ProcessLine(String line){
      this.line = line;
    }
  }

  public static class LineProcessed{}

  public static LineProcessed LINE_PROCESSED = new LineProcessed();
}