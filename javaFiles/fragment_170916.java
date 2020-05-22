thread.start();
while(thread.isAlive()){};
try {
     DatabaseConnectivity ndbc = new DatabaseConnectivity("select","");
     ndbc.FrameShow();

} catch (SQLException ex) {
     Logger.getLogger(RegisterService.class.getName()).log(Level.SEVERE,   null, ex);
}