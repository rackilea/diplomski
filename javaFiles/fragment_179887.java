for (int i=0;i<100;i++)
{
    try {
        URL url=findWebsite();
        System.out.println(readURL(url));
    }
    catch (Exception e)
    {
    }
}