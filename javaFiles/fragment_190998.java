public int execToken(File f) throws Exception
{
    BufferedReader br = new BufferedReader(new FileReader(f));
    String line;
    int count = 0;
    Pattern layID = Pattern.compile("LAYID=LY_\\d+");
    Matcher matcher = null;
    boolean isSingle = true;
    while ((line = br.readLine()) != null)
    {
        if(line.contains("LAYID=LY_00"))
        {
            isSingle = false;
            continue;
        }
        matcher = layID.matcher(line);
        if(matcher.find())
        {
            count++;
            if(!isSingle)
                count++;
        }

        isSingle = true;
    }
    return count;
}