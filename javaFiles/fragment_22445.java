public class TestGUI extends JPanel{
private List<Integer> myArrayList;

TestGUI(List<Integer> myArrayList){
    Box verticalBox = Box.createVerticalBox();
    verticalBox.add(new TestPanel(myArrayList));
    verticalBox.add(new TestPanel(myArrayList));
    verticalBox.add(new TestPanel(myArrayList));
    this.add(verticalBox, BorderLayout.CENTER);
    this.myArrayList = myArrayList;
}
void anotherMethod(){
    // want to be able to add or delete records to same ArrayList here
    myArrayList.add(5);
    myArrayList.add(3);
    myArrayList.add(0);
    myArrayList.add(9);
}