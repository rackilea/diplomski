DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

PrintService[] printerArray = dialogPrinters.toArray(new PrintService[dialogPrinters.size()]);

// call print dialog and get print attributes
PrintService selectedPrinter = javax.print.ServiceUI.printDialog(null, 200, 200, printerArray, defaultPrintService, flavor, pras);  

// check if "print-to-file" option used
if (pras.get(Destination.class) != null)
{
    // here we deny to perform the save into a file
    JOptionPane.showMessageDialog(CMSJRViewer.this, getBundleString("error.printing"));
    throw new PrintException("Print to file option not allowed. Action aborted!");
}
else
{
    ...
}