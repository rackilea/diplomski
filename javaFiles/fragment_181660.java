public void saveToFile(int count)
{
    BufferedWriter bw = null;
    try
    {
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("countStorage"))));
        bw.write(count);
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    finally
    {
        if(bw != null)
        {
            try
            {
                bw.close();
            }
            catch(IOException e) {}
        }
    }
}

public int readFromFile()
{
    BufferedReader br = null;
    try
    {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("countStorage"))));
        String line = br.readLine();
        int count = Integer.parseInt(line);
        return count;
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    finally
    {
        if(br != null)
        {
            try
            {
                br.close();
            }
            catch(IOException e) {}
        }
    }
}