jList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
               selectedValues = jList1.getSelectedValuesList(); 
                        // it will return a list of values
                        //evt.getFirstIndex() - the index of last selected item
                       //evt.getLastIndex() - the index of current selected item
            }
        });