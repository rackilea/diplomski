private void jCBCustomersActionPerformed(java.awt.event.ActionEvent evt) {      
    Appointment app = new Appointment();

    // collect all of your current data in jcombobox
    ArrayList<String> current_list = new ArrayList<>();
    int count = this.jCBCustomers.getItemCount(); // get count of them
    for (int i = 0; i < count; i++) {
        current_list.add((String) this.jCBCustomers.getItemAt(i)); // add them to current list
    }

    // data that returned from database
    ArrayList<String> returned_from_db_list = jcbNames(); // calling jcbNames method

    /*
        for each string that has returned from database , 
        if it doesn't in the current_list 
        you can add it to jcombobox , so ...
    */ 
    for (String str : returned_from_db_list) {
        if ( !current_list.contains(str) ) { // check for existing in the current_list
            current_list.add(str); // adding fresh data to current_list!
            /*
                or you can add them directly to jcombobox and remove above statement.
                this.jCBCustomers.addItem(str); // add updated data to jcombobox
            */
        }
    }

    /* 
        if   ::: you use   current_list.add(str); in above for-each-loop ,
               now you must update jcombobox data !
        else ::: remove below loop.
    */
    for (String singleStr : current_list) {
        this.jCBCustomers.addItem(singleStr); // add updated data to jcombobox
    }
}