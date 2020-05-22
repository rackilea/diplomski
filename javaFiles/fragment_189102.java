for(int i=0; i < 5; i++) { 
        JButton btn = new JButton(); 
        //System.out.print(i);
        btn.setText("Button " + i);
        frame.add(btn);                 //adding to frame
        System.out.print(btn.getText() + " ");
    }