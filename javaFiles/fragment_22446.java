public class TestPanel extends JPanel {
private ArrayList<Integer> myArrayList;
public TestPanel (ArrayList<Integer> myArrayList){
    this.setBackground(getRandomColor());
    this.setBorder( new EtchedBorder() );
    this.setSize(150,20);
    this.myArrayList = myArrayList;
}
void anotherMethod(){
    //want to be able to add or delete records from same ArrayList here
    myArrayList.remove(1);
    myArrayList.remove(2);
    myArrayList.remove(3);
}