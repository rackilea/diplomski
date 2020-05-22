import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) throws ParseException {
    List<AddList> addList = new ArrayList<AddList>();
    List<DeleteList> delList = new ArrayList<DeleteList>();
    AddList addL1 = new AddList();
    AddList addL2 = new AddList();
    AddList addL3 = new AddList();
    AddList addL4 = new AddList();
    AddList addL5 = new AddList();
    AddList addL6 = new AddList();
    AddList addL7 = new AddList();

    DeleteList delL1 = new DeleteList();
    DeleteList delL2 = new DeleteList();
    DeleteList delL3 = new DeleteList();

    addL1.setId(2001);
    addL1.setParentId(3);
    addL2.setId(2002);
    addL2.setParentId(2001);
    addL3.setId(2003);
    addL3.setParentId(2001);
    addL4.setId(2004);
    addL4.setParentId(2002);
    addL5.setId(2005);
    addL5.setParentId(2003);
    addL6.setId(2006);
    addL6.setParentId(4);
    addL7.setId(2007);
    addL7.setParentId(2006);

    delL1.setDeleteId(2001);
    delL2.setDeleteId(3);
    delL3.setDeleteId(2007);

    addList.add(addL1);
    addList.add(addL2);
    addList.add(addL3);
    addList.add(addL4);
    addList.add(addL5);
    addList.add(addL6);
    addList.add(addL7);

    delList.add(delL1);
    delList.add(delL2);
    delList.add(delL3);

    removeElements(addList, delList);
}

public static void removeElements(List<AddList> add, List<DeleteList> del) {
    boolean status = true;
    int[] temp = new int[del.size()];
    int[] child = new int[add.size()];
    int i = 0;
    while (status) {
        for (int j = 0; j < add.size(); j++) {
            if (del.get(i).getDeleteId() == add.get(j).getId()) {
                add.remove(j);
                temp[i] = del.get(i).getDeleteId();
                j = -1;
            }
        }
        i++;
        if (i == del.size()) {
            status = false;
        }
    }
    i = 0;
    int k = 0;
    boolean newStatus = true;
    while (newStatus) {
        for (int j = 0; j < add.size(); j++) {
            if (temp[i] == add.get(j).getParentId()) {
                child[k] = add.get(j).getId();
                add.remove(j);
                k++;
                j = -1;
            }
        }
        i++;
        if (i == del.size()) {
            newStatus = false;
        }
    }
    i = 0;
    boolean con = true;
    while (con) {
        for (int j = 0; j < del.size(); j++) {
            if (temp[i] == del.get(j).getDeleteId()) {
                del.remove(j);
                j = -1;
            }
        }
        i++;
        if (i == temp.length) {
            con = false;
        }
    }

    i = 0;
    boolean cons = true;
    while (cons) {
        for (int j = 0; j < add.size(); j++) {
            if (child[i] == add.get(j).getParentId()) {
                add.remove(j);
                j = -1;
            }
        }
        i++;
        if (i == child.length) {
            cons = false;
        }
    }
}

}