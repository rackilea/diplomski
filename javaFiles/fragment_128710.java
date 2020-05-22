BufferedWriter bw = null;
try
{
    /*...*/
    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw);
    out.print(xmlTableProducer.getDynamicText());

    JOptionPane.showMessageDialog(this, "File Saved Successfully!", "Saved", JOptionPane.INFORMATION_MESSAGE);
}
catch(IOException xcp)
{
    xcp.printStackTrace(System.err);
} finally {
    try 
    {
        bw.close();
    } 
    catch    (Exception exp) {
    }
}