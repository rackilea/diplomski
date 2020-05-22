public class ScannetworkWorker
    extends SwingWorker<String, String>
{

  private final JTextPane mOutputPane;

  public ScannetworkWorker(JTextPane aOutputPane)
  {
    super();
    mOutputPane = aOutputPane;
  }

  @Override
  protected String doInBackground() throws Exception
  {
    Process p = null;
    try
    {
      p = Runtime.getRuntime().exec("ipconfig /all");
    }
    catch (IOException ex)
    {
      Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
    }

    BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line = "";
    String output = "";

    try
    {
      while ((line = buf.readLine()) != null)
      {
        publish(line);
        output += line + "\n";
      }
    }
    catch (IOException ex)
    {
      Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
    }

    try
    {
      p.waitFor();
    }
    catch (InterruptedException ex)
    {
      Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
    }

    return output;
  }

  @Override
  protected void process(List<String> aChunks)
  {
    final String intermediateOutput = aChunks.stream().collect(Collectors.joining("\n"));
    final String existingText = mOutputPane.getText();

    final String newText = existingText + "\n" + intermediateOutput;

    mOutputPane.setText(newText);
  }

}