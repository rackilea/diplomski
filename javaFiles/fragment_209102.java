DecimalFormat f = new DecimalFormat("#0.00");
public ArrayList<String> listContent; 
DefaultListModel<String> ListModelNew = new DefaultListModel<String>();

public static void main(String args[]) {
ClassA pMain = new ClassA();
listContent = new ArrayList<String>(pMain.collCollect);
for (int i = 0; i < listContent.size(); i++){
        ListModelNew.add(i, listContent.get(i));
    } 
}