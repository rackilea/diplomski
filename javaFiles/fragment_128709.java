try
{
    /*...*/
    FileWriter fw = new FileWriter(file.getAbsoluteFile());
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw);
    out.print(xmlTableProducer.getDynamicText());
    out.close();
    bw.close();

    JOptionPane.showMessageDialog(this, "File Saved Successfully!", "Saved", JOptionPane.INFORMATION_MESSAGE);
}
catch(IOException xcp)
{
    // If an exception occurs, the file will remain open
    xcp.printStackTrace(System.err);
}