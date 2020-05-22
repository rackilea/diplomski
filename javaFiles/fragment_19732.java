try (BufferedReader fw = new BufferedReader(new FileReader(new File("text.txt"))))
{
    String s;
    while((s = fw.readLine()) != null)
    {
        if(s.equals("[a]"))
        {
            String author = fw.readLine(); //read the next line after [a]
            System.out.println(author); //the line after [a]
        }
        if(s.equals("[c]"))
        {
            StringBuilder content = new StringBuilder();
            while((s = fw.readLine()) != null)
                content.append(s + " ");
            System.out.println(content); //the line after [c]
        }
    }
} catch (IOException exp)
{
    exp.printStackTrace();
}