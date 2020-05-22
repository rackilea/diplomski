public class PassThroughLineMapper implements LineMapper<String> {
  @Override
  public String mapLine(String line, int lineNumber) throws Exception {
    return line;
  }
}