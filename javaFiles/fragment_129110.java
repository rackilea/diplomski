public void actionPerformed(ActionEvent e){
    if (!authorized){
        String u = userT.getText();
        String pw = pwT.getText();
        try {
            authorized = Login2.loginfunc(u,pw);
            if(authorized) {
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
            }
        }
        catch(IOException exc){
            exc.printStackTrace();
        }
        logB.setSelected(false);
    }       
}