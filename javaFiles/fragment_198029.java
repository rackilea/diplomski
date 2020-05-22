public static void main(String[] args) {
        // TODO code application logic here
       Controller controller = new Controller();
       controller.initializeSystem();
   }
   public void initializeSystem(Controller _controller){
       mainWindow = new MainWindow(this);
       mainWindow.setVisible(true);
   }