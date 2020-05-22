while(c.moveToNext())
{
    String name = c.getString(0);   
    String desc = c.getString(1);   
    String pic = c.getString(2);    

    MainScreenEntered.names.add(name);
    MainScreenEntered.descriptions.add(desc);
    MainScreenEntered.pics.add(pic);
}