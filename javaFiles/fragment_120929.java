public static final int CHECK_LINE_NR = 4;
public static final String EXPECTED_LINE_VALUE = "inbound=OFF|outbound=OFF";

public boolean verifyScriptOutput(ChannelExec channel)
  throws IOException
{
  // Check all lines in output
  BufferedReader    reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
  String            line;
  int               linenr = 0;
  while ((line = reader.readLine()) != null)
  {
    linenr++;
    if (linenr == CHECK_LINE_NR)
      return (line.equals(EXPECTED_LINE_VALUE));
  }

  // If we get here, output has less lines
  return (false);

} // verifyScriptOutput