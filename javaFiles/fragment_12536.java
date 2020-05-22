import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


public class Test1 extends JFrame {

public Test1() {
    super("Test");

    ArrayList<Test2> list = new ArrayList();
    list.add(new Test2("March", "xyz", "John"));
    list.add(new Test2("March", "xyz", "Joe"));
    list.add(new Test2("March", "abc", "Nick"));
    list.add(new Test2("March", "abc", "Phil"));

    Iterator iter = list.iterator();
    String prevMonth = "";
    String prevType = "";

    DefaultMutableTreeNode top = new DefaultMutableTreeNode("List");
    DefaultMutableTreeNode month = null;
    DefaultMutableTreeNode type  = null;

    while (iter.hasNext()) {
        Test2 t = (Test2) iter.next();
        if (!t.getMonth().equals(prevMonth)) {                
            if (month != null) {                   
                top.add(month);
            }
            month = new DefaultMutableTreeNode(t.getMonth());
            prevMonth = t.getMonth();

        }
        if (!t.getType().equals(prevType)) {                
            if (type != null) {                    
                month.add(type);
            }
            type = new DefaultMutableTreeNode(t.getType());
            prevType = t.getType();
        }            
        type.add(new DefaultMutableTreeNode(t.getName()));
    }
    month.add(type);
    top.add(month);
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(new JScrollPane(new JTree(top)));

    this.pack();
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

}

public static void main(String a[]) {
    Test1 t1 = new Test1();
}
}