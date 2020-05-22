public AdminMasterPanel(JFrame mf, Admin admin) {

   // Set the frame to the program
   myFrame = mf;
   setLayout(null);
   setBounds(0, 0, 1280, 720);
   this.admin = admin;
   System.out.println("WHY YOU ARE NOT WORKING?! "+getAdmin());
 }