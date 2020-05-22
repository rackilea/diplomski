public void setType (String aType)
{
    if (!aType.equalsIgnoreCase("Red Delicious") 
        && !aType.equalsIgnoreCase("Golden Delicious") 
        && !aType.equalsIgnoreCase("Gala") 
        && !aType.equalsIgnoreCase("Granny Smith"))
    {
        System.out.println ("That is an invalid type of apple");
        return;
    }
    this.type = aType;
}