.(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {

            if (! e.getValueIsAdjusting() ) {
              ListSelectionModel d = (ListSelectionModel)e.getSource();
              if(d.getLeadSelectionIndex() != -1){
                   String hehe = (String) model.getValueAt(d.getLeadSelectionIndex(), 7);
                   b_extend.setEnabled("".equals(hehe));
              }
            }

            }
        });