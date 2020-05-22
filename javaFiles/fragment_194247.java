private Runnable callback;

public void theMethod(){
    System.out.println("I was triggered by another far away view");
    SwingUtilities.invokeLater(this.callback);
}