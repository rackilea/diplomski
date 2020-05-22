PrinterJob gap = PrinterJob.getPrinterJob();
PageFormat pf = gap.defaultPage();

//Manually assign some of the basic print settings (More advanced things may require you to write your own code)
gap.setJobName("My Print Jnb");

//Set custom page size?
Paper paper = new Paper();
paper.setSize(595, 842);
pf.setPaper(paper);

//Set page orientation?
pf.setOrientation(PageFormat.LANDSCAPE);

//Create the print job with our manual settings
gap.setPrintable(this, pf);

try
{
    //And finally print it out
    gap.print();
}
catch (PrinterException e)
{
    JOptionPane.showMessageDialog(null, " ERROR DEL PROGRAMA", "ERROR \n " + ex , JOptionPane.INFORMATION_MESSAGE);
}