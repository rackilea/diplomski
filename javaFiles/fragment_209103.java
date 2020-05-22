DecimalFormat f = new DecimalFormat("#0.00");
DefaultListModel<String> ListModelNew = new DefaultListModel<String>();

public static void main(String args[]) {
ClassA pMain = new ClassA();
for (int i = 0; i < pMain.collCollect.size(); i++){
        ListModelNew.add(i, pMain.collCollect.get(i));
    } 
}