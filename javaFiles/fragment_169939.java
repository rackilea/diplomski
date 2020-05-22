jl[i].addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                   //Better to check if its returning JLabel obejct using instance of
                   JLabel c = (JLabel) me.getComponent();
            }
    });