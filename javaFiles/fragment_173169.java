@Override
        public void actionPerformed(ActionEvent e) {
            label.setText("second text");
            new Thread(){
              public void run(){
                try {
                  //Thread.currentThread();
                  Thread.sleep(4000);
                  label.setText("third text");
               } catch (InterruptedException exc) {
                System.out.println("Erorrrrr");
             }
           }
         }.start();

        }