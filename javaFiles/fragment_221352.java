public class AllItems{
    Map<String,Item> allItems;

    public AllItems(){
        allItems = new HashMap<String,Item>();
        //Load all items here(You can save them all in one file)
    }

    public Item getItem(String name){
        return allItems.get(name);//You need to make this always work, so you should check if the item exists first.
    }
}