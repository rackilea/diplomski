JButton jb = ...
    jb.addActionListener( new ActionListener() {
        public void actionPerformed( final ActionEvent e ) {
          final Thread t = new Thread( new Runnable() {
           public void run() {
             // this shall get executed, after start() has been called, outside the EDT    
             }
           });
           t.start();
        }
    } );