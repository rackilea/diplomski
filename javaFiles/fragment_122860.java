try
{
    String line=null;
    String filePath="\"YOUR FILE PATH\"";
    Process p = Runtime.getRuntime().exec("toolTipInfo.bat "+filePath);
    String processDesc="";
    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));       
    while ((line = input.readLine()) != null)
    {
        if(line.contains("File description:"))
            processDesc=line.split(":")[1].trim();
    }
    input.close();
}
catch(IOException e)
{

}