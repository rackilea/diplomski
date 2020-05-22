private void initilaize()
    {

                // Add column to show the start time.
                  TextColumn<Times> startColumn 
                  = new TextColumn<Times>() {
                     @Override
                     public String getValue(Times times) {
                        return Double.toString(times.getStart());
                     }
                  };
                  table.addColumn(startColumn, "Beginn");

               // Add column to show the pause time.
                  TextColumn<Times> pauseColumn 
                  = new TextColumn<Times>() {
                     @Override
                     public String getValue(Times times) {
                        return Integer.toString(times.getPause());
                     }
                  };
                  table.addColumn(pauseColumn, "Pause in Minuten");

               // Add column to show the end time.
                  TextColumn<Times> endColumn 
                  = new TextColumn<Times>() {
                     @Override
                     public String getValue(Times times) {
                        return Double.toString(times.getEnd());
                     }
                  };
                  table.addColumn(endColumn, "Ende");



                  //table panel
                  panel.setBorderWidth(1);      
                  panel.setWidth("400");
                  panel.add(table);
                  panel.getElement().setId("mainTable");


                  // Add the widgets to the root panel.
                  RootPanel.get().add(panel);
     }

    public void createTimeTable(){
            //Table and Panel -> created globally
            //On Load -> get all times which are already booked
            serviceImplURL.getRpcDB().getBookedTimes(username, 
new AsyncCallback<ArrayList<Times>>() {
                /**
                */
                @Override
                public void onFailure(Throwable caught) {
                    // TODO Auto-generated method stub

                }
                /**
                */
                @Override
                public void onSuccess(ArrayList<Times> startList) {
                    /**
                    */
                        table.setRowCount(startList.size(), true);
                        table.setRowData(0, startList);

                }               
            });