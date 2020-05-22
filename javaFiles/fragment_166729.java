public static void main(String argv[]) throws Exception 
{
    New e= new   New ();
    e.connectDB();
    if(argv.length == 0)
        e.xmlExport("D:\\export.xml");
    else 
        e.xmlExport(argv[0]);
}