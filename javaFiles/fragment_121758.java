public class gridCreator extends JFrame implements ActionListener{
    ObjectCreator obj = new ObjectCreator();
    GridLayout itemGrid = new GridLayout();
    JFrame frame = new JFrame("pls work");
    static gridCreator instance;

public static void main(String[] args) throws FileNotFoundException {
    instance = new gridCreator();
    instance.createGrids();
    instance.createAndShowGUI();
}
public void createGrids() throws FileNotFoundException{
    obj.loadItems();
    itemGrid.setColumns(20);
    itemGrid.setRows(4);
    for (ObjectCreator.Item item : obj.items){
        addComponentsToPane(item);
    }
}
private void addComponentsToPane(ObjectCreator.Item item) {
    JButton button = new JButton(item.getName());
    frame.add(button);
}
@Override
public void actionPerformed(ActionEvent e) {
    //do actions here   
}