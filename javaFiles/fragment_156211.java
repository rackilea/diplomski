for (int i = 0; i < america.length && i < british.length; i++)
{
    if (word.equals(america[i])) 
    {
        System.out.println(america[i] + " in british is: " + british[i]);
        System.exit(0);
    }
}

System.out.println("Word not found in the dictionary.");