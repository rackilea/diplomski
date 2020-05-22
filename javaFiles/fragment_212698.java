import net.rim.device.api.system.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.util.Comparator;
import net.rim.device.api.util.StringUtilities;
import net.rim.device.api.collection.util.*;

public class CheckMenu extends UiApplication {
    public static void main(String[] args) {
        CheckMenu myApp = new CheckMenu();       
        myApp.enterEventDispatcher();
    }

    public CheckMenu() {        
        pushScreen(new MyScreen());
    }    
}

class MyScreen extends MainScreen {
    KeywordFilterField myList = new KeywordFilterField();
    MyItemList myItems = new MyItemList();

    public MyScreen() {
        setTitle(myList.getKeywordField());

        myItems.doAdd(new MyItem(1, "Eins"));
        myItems.doAdd(new MyItem(2, "Zwei"));
        myItems.doAdd(new MyItem(3, "Drei"));
        myItems.doAdd(new MyItem(4, "Vier"));

        myList.setSourceList(myItems, new MyItem.MyProvider());
        // XXX commenting the line below does not help
        myList.setCallback(new MyListFieldCallback());
        add(myList);
    }

    private MenuItem numMenu = new MenuItem("num sort", 0, 0) {  
    public void run() {
        MyItem.NUMERIC_SORT = true;
        Status.show("Use " + toString());
        setText("num sort \u221A");
        alphaMenu.setText("alpha sort");
        myItems.sort();
        myList.updateList();
    }
};
private MenuItem alphaMenu = new MenuItem("alpha sort", 1, 0) {  
    public void run() {
        MyItem.NUMERIC_SORT = false;
        Status.show("Use " + toString());
        setText("alpha sort \u221A");
        numMenu.setText("num sort");
        myItems.sort();
        myList.updateList();
    }
};

protected void makeMenu(Menu menu, int instance) {
    super.makeMenu(menu, instance);
    menu.add(numMenu);
    menu.add(alphaMenu);
}

private class MyListFieldCallback implements ListFieldCallback {

    public void drawListRow(ListField listField, Graphics g, int index, int y, int    width) {
        Object obj = ((KeywordFilterField)listField).getElementAt(index);
        if(obj != null && obj instanceof MyItem) {
            MyItem item = (MyItem) obj;
            g.drawText(item.toString(), 20 * (1 + index), y);
        } else if(index == 0) {
            g.drawText("ssssssss", 0, y);
        }
    }

    public Object get(ListField listField, int index) { 
        return null; 
    }

    public int getPreferredWidth(ListField listField) { 
        return 0; 
    }

    public int indexOfList(ListField listField, String prefix, int start) { 
        return 0; 
    }
}
}

class MyItemList extends SortedReadableList {
    public MyItemList() {
        super(new MyItem.MyComparator());        
    } 

    protected void doAdd(Object obj) {
        super.doAdd(obj);   
    }

    protected boolean doRemove(Object obj) {
        return super.doRemove(obj);        
    }
 }

class MyItem {
    public static boolean NUMERIC_SORT;

    private int _num;
    private String _name;

    public MyItem(int num, String name) {
        _num = num;
        _name = name;
    }

    public String toString() {
        return _num + ": " + _name;
    }

    static class MyComparator implements Comparator {
        public int compare(Object obj1, Object obj2) {
            if (! (obj1 instanceof MyItem && obj2 instanceof MyItem))
                throw new IllegalArgumentException("Cannot compare non-MyItems");

            MyItem item1 = (MyItem) obj1;
            MyItem item2 = (MyItem) obj2;

            if (MyItem.NUMERIC_SORT) {
                if (item1._num == item2._num)
                    return 0;
                return (item1._num > item2._num ? 1 : -1);
            }

            return item1._name.compareTo(item2._name);
        }
    }

    static class MyProvider implements KeywordProvider {
        public String[] getKeywords(Object obj) {
            if (obj instanceof MyItem) {
                MyItem item = (MyItem) obj;
                return new String[]{ Integer.toString(item._num), item._name };
            }
        return null;
    }
}
}