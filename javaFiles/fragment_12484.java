public void appendToView(String text) {
   view.post(new Runnable() {
       @Override
       public void run() {
           view.append(text + "\n");
       }
    });
}