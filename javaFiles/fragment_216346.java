public void submit(){
    String recordvalues = ""; //contains a String representation of what I want to submit
    TableModel model = tableEntry.getModel();
    for(int a = 0; a < model.getColumnCount();a++){
        for(int b = 0; b < model.getRowCount();b++){
            if(a != 0){ //I want to skip the first column
                recordvalues = recordvalues  + (String) model.getValueAt(b, a) + ","; //The error is at this line in the code
            }
        }
    }
}