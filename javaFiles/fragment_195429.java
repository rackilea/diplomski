DefaultTableModel tm = (DefaultTableModel)scoreTBL.getModel();
while(rs.next())
{
java.util.Vector row = new java.util.Vector();

for(int i=1; i<=4;i++)
{
row.add(rs.getString(i));
}

tm.addRow(row);
}