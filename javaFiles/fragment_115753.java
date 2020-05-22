private Timer timer = null;

// ...

JButton btnIniciar = new JButton("Iniciar");
btnIniciar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) { 
        // prevent the timer from running again if it is already running
        if ( timer != null && timer.isRunning() ) return;

        timer = new Timer(50, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //I have a list of packages to animate
                for (Package p: listaPaquetes){
                    p.animate();
                    panel.repaint();
                }                             
            }
        });

        timer.start();
    }