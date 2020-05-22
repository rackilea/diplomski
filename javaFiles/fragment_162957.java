// the table that displays the data
        TableLayout dataTable;
// THE DATA TABLE
        dataTable=(TableLayout)findViewById(R.id.data_table);


   /**
     * updates the table from the database.
     */
    private void updateTable()
    {


      // delete all but the first row.  remember that the count
      // starts at one and the index starts at zero


  while (dataTable.getChildCount() > 1)
    {
            // while there are at least two rows in the table widget, delete
            // the second row.
            dataTable.removeViewAt(1);
    }

        // collect the current row information from the Server and
        // store it in a two dimensional ArrayList
        ArrayList<ArrayList<Object>> data = getAllRowsAsArrays();

        // iterate the ArrayList, create new rows each time and add them
        // to the table widget.
        for (int position=0; position < data.size(); position++)
        {
                TableRow tableRow= new TableRow(this);

                ArrayList<Object> row = data.get(position);

                TextView idText = new TextView(this);
                idText.setText(row.get(0).toString());
                tableRow.addView(idText);

                TextView textOne = new TextView(this);
                textOne.setText(row.get(1).toString());
                tableRow.addView(textOne);

                TextView textTwo = new TextView(this);
                textTwo.setText(row.get(2).toString());
                tableRow.addView(textTwo);

                dataTable.addView(tableRow);
        }
    }