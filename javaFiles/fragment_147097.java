try
{
    Process p = Runtime.getRuntime().exec("notepad Q:/Test/tmp.txt");
    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
    stdInput.close();
}
catch(Exception k)
{
    JOptionPane.showMessageDialog(null, k.getMessage());
}