public void readFile()
{
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("AudioLinks")));
        String text;
        try {
            while((text=reader.readLine())!=null)
            {
                System.out.println(text);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}