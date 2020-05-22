@Service 
public class MyService{

   @Autowired
   ItemFactory itemFactory;

   public someMethod(){
      Item item = itemFactrory.createItem();
   } 

}