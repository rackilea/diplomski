try
{
    FileInputStream fr=new FileInputStream("Image.jpeg");
    FileOutputStream fr1=new FileOutputStream("Text.txt");
    PrintWriter out = new PrintWriter(fr1);
    int temp=0;
    while((temp=fr.read())!=-1)
    {                       
        out.write(Integer.toBinaryString(temp) + " ");
    }
    out.close();
    fr1.close();
    fr.close();
}
catch(Exception e)
{
    System.out.println(e);
}