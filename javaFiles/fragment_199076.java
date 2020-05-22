public static void main(String[] args) {
   EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                final UI ui = new UI();
                new Thread() {
                  public void run() {
                    doSomething(ui);
                  }
                }.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

}

public static void doSomething(UI ui) {