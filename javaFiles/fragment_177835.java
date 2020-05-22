String columns = new String[] {"Name", "Age"};
ArrayList<Person> data = getYourData();

DefaultTableModel dm = new DefaultTableModel(data.size(), columns.length);
JTable table = new JTable(dm);

for(Person p : data) {
   table.addRow(new String[]{p.name, p.age});
}