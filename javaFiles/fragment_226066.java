Map<String,String> memoMap = AvoCollection.getMemoMap();
String[][] data = new String[memoMap.size()][];
int ii =0;
for(Map.Entry<String,String> entry : memoMap.entrySet()){
    data[ii++] = new String[] { entry.getKey(), entry.getValue() };
}
final DefaultTableModel model = new DefaultTableModel(data,new String[]{"Memo","ID"});