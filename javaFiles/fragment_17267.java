ls2Handler = new ListSelectionListener(){
        @Override
            public void valueChanged(ListSelectionEvent e) {
          if (e.getValueIsAdjusting() == false) {

              if (ownBookList.getSelectedValue()!=null) {
                  userlist.clearSelection();
                  Global.selectedUser =  ownBookList.getSelectedValue().toString();
                  Global.selectedIndex = ownBookList.getSelectedIndex();
                  updateFields(Global.selectedUser);
              }

                else {

                    }

          }

    }
};

    lsHandler = new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent e) {
              if (e.getValueIsAdjusting() == false) {

                  if (userlist.getSelectedValue()!=null) {
                     ownBookList.clearSelection();
                      Global.selectedUser =  userlist.getSelectedValue().toString();
                      Global.selectedIndex = userlist.getSelectedIndex();
                      updateFields(Global.selectedUser);


                  }
                  else {

                  }
              }


        }
        };