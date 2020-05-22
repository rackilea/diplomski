public void userConnected(UserManagerEvent evt) { // You would need to define all this yourself...
    final Conexion user = evt.getConnection(); // You would need to define this event yourself...
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            listModel.addElement(user);
        }
    });
}