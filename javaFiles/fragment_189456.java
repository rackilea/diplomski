for(String[] sound : Sounds)
{
    for(String soundName : sound)
    {
        if(soundName.equals(searchString))
        {
             System.out.print(soundName);
        }
    }
}