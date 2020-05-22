public class ItemFactory{

    public static Item addItem(String typeofItem){
        switch(typeofItem){
             case "Sword":
                return new Sword();
             case "Potion":
                return new Potion();
             ...
            default:
               //put any code here that is like the "else" of an if-else block
              return null;
        }
    }

}