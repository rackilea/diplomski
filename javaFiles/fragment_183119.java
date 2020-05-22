// JFrame settings
    frame.add(panel);
    frame.getContentPane().add(BorderLayout.CENTER, panel);
    frame.setSize(860,500);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);


    if(Frame.getFrames().length > 1){
        Frame[] f = Frame.getFrames();
                for(Frame frames : f){
            if(!frames.getName().equals(name)){
                frames.dispose();
            }
            }
    }