String username="";
/**     
 * Creates new form Welcome_Screen
 */
public Welcome_Screen(String userName) {
    initComponents();
     conn = javaconnect.ConnecrDB();
     //this. keyword is very important otherwise the 
     //local variable won't set the frame variable.
     this.userName = userName;
     Update_table();
     Update_table2();
     update_elements();
}