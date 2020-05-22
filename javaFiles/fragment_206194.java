DefaultTableModel memberTable= ...;

for(int i = 0; i < memberArrayList.size(); i++){
    Object[] rowData = new Object[]{
        memberArrayList.get(i).getFirstName(),
        memberArrayList.get(i).getLastName(), 
        memberArrayList.get(i).getEmail(), 
        memberArrayList.get(i).getPhoneNumber(),
        memberArrayList.get(i).getLevel()
        };
    memberTable.addRow(rowData);
}