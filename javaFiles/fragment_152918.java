public class Tmp {  

private List<Integer> Items = new ArrayList<Integer>();

public void setItems(List<Integer> myItems) { 
    for (int i = 0; i < myItems.size(); i++) {    //<<This loop shows the items
        System.out.println(myItems.get(i));
    }
    this.Items.clear();
    this.Items.addAll(myItems);
    System.out.println();
    for (int i = 0; i < Items.size(); i++) {  //<< this loop also shows the item
        System.out.println(Items.get(i));
    }
}
public static void main(String[] args) {
    Tmp t = new Tmp();
    List<Integer> myList = new ArrayList<Integer>();
    myList.add(3);
    myList.add(4);

    t.setItems(myList);


}