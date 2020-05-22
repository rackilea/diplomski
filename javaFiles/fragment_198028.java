public static void main(String[] args) {
        // TODO code application logic here
       Controller controller = new Controller();
       controller.initializeSystem(controller);
   }
   public void initializeSystem(){
       mainWindow = new MainWindow(_controller);
       mainWindow.setVisible(true);
   }