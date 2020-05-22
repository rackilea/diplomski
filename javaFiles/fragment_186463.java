public void add(String itemName)
{
    Bag2 bag2 = new Bag2();
    Bag2.Item item = bag2.new Item(itemName.toUpperCase(), 1);

    if (aList.isEmpty())
    {
        aList.add(item);
    } else 
    {
        boolean existing = false;
        for(int i = 0; i < aList.size();i++)
        {   
            if (item.compareTo(aList.get(i))==0)
            {
                aList.get(i).quantity++;
                existing=true;
                break;
            }               
        }
        if(!existing) {aList.add(item);}
    }
}