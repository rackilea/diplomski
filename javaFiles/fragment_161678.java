public void actionPerformed(ActionEvent e) {
    if ("Start" == e.getActionCommand() && pbTask == null) {
        theButton.setText("Stop");
        theButton.setActionCommand("Stop");
        (pbTask = new PBTask()).execute();
    } else if ("Stop" == e.getActionCommand()) {
        theButton.setText("Start");
        theButton.setActionCommand("Start");
        pbTask.cancel(true);
        pbTask = null;
    } else {
        alertMsg("Thread still running.");
    }
    try {
        pbTask.get();
    } catch (InterruptedException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (ExecutionException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    System.out.println("DONE");
}