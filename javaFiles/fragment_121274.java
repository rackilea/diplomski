public class TestPrinterSmall  {
static class JPanelPrintable extends JPanel implements Printable {
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) return Printable.NO_SUCH_PAGE;
        printAll(g);  
        return Printable.PAGE_EXISTS;
    }
};
private static void printIt(Printable p) throws PrinterException {
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(p);
    if (job.printDialog()) job.print();
}    
public static void main(String args[]) throws PrinterException {
    final JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setSize(400,400);
    final JPanelPrintable j = new JPanelPrintable(); 
    j.setLayout(new BorderLayout());
    j.add(new JButton("1111"),BorderLayout.NORTH);
    j.add(new JButton("2222"),BorderLayout.SOUTH);            
    f.add(j);f.repaint();f.pack();
    //f.setVisible(true);
    printIt(j);
}
}