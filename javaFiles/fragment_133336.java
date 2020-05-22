long startTime= System.nanoTime() ;
try {
    SearchDetailsDialog dialog = new SearchDetailsDialog(null);
    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    dialog.setVisible(true);
} catch (Exception e) {
    e.printStackTrace();
} finally {
    long endTime= System.nanoTime() ;
    double totalTime= ((double)(endTime - startTime)/1000000000) ;
    System.out.printf("the execution time is: %.3f seconds",totalTime);
}