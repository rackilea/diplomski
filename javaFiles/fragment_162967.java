JTextArea toPrint = new JTextArea("Text here.");
try {
    boolean done = toPrint.print();
    JOptionPane.showMessageDialog(new JFrame(),"Printing "+(done?"completed":"canceled"));
} catch(PrinterException ex) {
    JOptionPane.showMessageDialog(new JFrame(),"The printer messed up. " +ex.getMessage());
}