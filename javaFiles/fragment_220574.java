File file = new File ("xml_path");
BufferedReader br = new BufferedReader (new FileReader (file));
String info;

while (info = br.readLine() != null)
{
    if (info.contains("<catalog>"))
    {
        System.out.println(info);
        while (info = br.readLine() != null)
        {
            if (info.contains("</catalog>"))
            {
                 System.out.println(info);
                 break;
            }
            else System.out.println(info);
        }
    }
}