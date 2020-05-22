//get number of rows
    int row = tableRadio.getRowCount();
    for (int r = 0; r  < row; r++) {

        //get column0's values and convert to String
        String time = ( tableModel.getValueAt(r, 0).toString() );

        //split time into two arrays
        String[] timeSplit = time.split(":");

        //convert arrays to doubles 
        double hours = Double.parseDouble(timeSplit[0]);
        double min = Double.parseDouble(timeSplit[1]);

        //represent column0 values by number of hours
        double col0 = (min / 60) + hours;

        //get column1's values and convert to double
        double col1 = Double.parseDouble( tableModel.getValueAt(r, 1).toString() );

        //add values to series
        series.add(col0, col1);
    }//end of for loop`