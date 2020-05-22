class Login extends Form {
   MainForm f; //do not initiate

   public Login () {
     this.setLayout (BoxLayout.y());
     this.add(new Label("username:").add(new TextField("","username"));
     this.add(new Label("pw:").add(new TextField("","password"));
     Button login = new Button ("Login");
     login.addActionListener(e -> {
        f.provideParameters(providedName,providedPw);
        f.show();
     }
     Display.getInstance().scheduleBackgroundTask(new Runnable {
       public void run() {
         //initiation in the background
         f = new MainForm ();
       }
     );
}