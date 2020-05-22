public class DatabaseConnection {
   // MainWindow mainwindow = new MainWindow();  *** don't do this ***
   MainWindow mainwindow;

   public DatabaseConnection(MainWindow mainwindow) {
      this.mainwindow = mainwindow; // pass in the reference in the constructor
   }

   public void connect() {
      Connection conn = null;

      // ... etc

      // now we can call methods on the actual visualized object
      mainwindow.setStatusLabel("Connection");
   }