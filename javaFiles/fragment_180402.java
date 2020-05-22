data = "";
while((line = br.readLine()) != null)
{
    if(line.indexOf(text) >= 0)
    {
        //remove the first System.getProperty("line.separator") if
        //you don't want a leading empty line
        data += System.getProperty("line.separator") + line + 
            System.getProperty("line.separator");
    }
}
if (data.length() > 0) {
    p.sendMessage("+++++++++++GriefLog+++++++++++");
    p.sendMessage(data);
    p.sendMessage("++++++++++GriefLogEnd+++++++++");
}