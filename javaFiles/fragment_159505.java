public class Item{
      String a,b,c;
    }


    Item item=new Item();
    item.setA("a");
    Example<Item> itemExample=ExampleOf(item);
    List<Item> res=itemRepository.findAll(example);