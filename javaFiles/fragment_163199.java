public void actionPerformed(ActionEvent arg0) {
    if(psw != null && !psw.isDone()){
        closeDBConnection(psw.getSession());
        psw.cancel(true);
        psw = null;
        restoreData();
    }