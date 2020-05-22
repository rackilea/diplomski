if(table.getColumnModel().getColumn(column).getIdentifier().equals("Status")){//Here `Status` is column name
    if(value.toString().equals("OK")){//Here `OK` is the value of row

        c.setBackground(Color.GREEN);
    }   
}