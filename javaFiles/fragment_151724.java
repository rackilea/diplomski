public class Box {
    @Autowired
    List <IFruit> fruits; //This should contain all IFruit's in the ApplicationContext

    public void add (IFruit fruit) {
         fruits.add(fruit);
    }
}