// to hold the data
List<Object[]> data = new ArrayList<>();

// loop through the ResultSet
while(results.next())
{
    String id = results.getString("id");
    String date_collected = results.getString("date_collected");
    String date_disposed = results.getString("date_disposed");
    String person_in_charged = results.getString("person_in_charged");
    String status = results.getString("status");

    // add a new row of data
    data.add(new Object[] {id, date_collected, date_disposed, person_in_charged, status});
}

// after the loop: set the data as the model
jTable1.setModel(new javax.swing.table.DefaultTableModel(
    // convert from List to array
    data.toArray(new Object[][data.size()],
    // column headers
    new String [] { "ID", "Date collected", "Date disposed", "person in charged", "status" }
)); 

// other details from your code: moved outside of the loop...
jScrollPane1.setViewportView(jTable1);

if (jTable1.getColumnModel().getColumnCount() > 0)
{
    jTable1.getColumnModel().getColumn(0).setResizable(false);
    jTable1.getColumnModel().getColumn(1).setResizable(false);
    jTable1.getColumnModel().getColumn(2).setResizable(false);
    jTable1.getColumnModel().getColumn(3).setResizable(false);
 }