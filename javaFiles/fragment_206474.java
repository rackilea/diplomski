for (String key : h.keySet())
{
    System.out.println("Key: " + key);   
    for(String str : h.get(key))
    {
       System.out.println("\t" +str);
    }
}