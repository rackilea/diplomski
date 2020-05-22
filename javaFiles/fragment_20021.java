public static void write(String s) throws FileNotFoundException, IOException
{
    list = new Hashtable<Date,String>();
    FileOutputStream fos = new FileOutputStream(s);
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.writeObject(list);
}