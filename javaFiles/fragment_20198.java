FileInputStream psStream; 

try { 
  psStream = new FileInputStream("file.ps");
} catch (FileNotFoundException ffne) {
} 

if (psStream == null) { 
  return;
}

DocFlavor psInFormat = DocFlavor.INPUT_STREAM.POSTSCRIPT; 
Doc myDoc = new SimpleDoc(psStream, psInFormat, null); 
PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet(); 
aset.add(new Copies(5)); 
aset.add(MediaSize.A4); 
aset.add(Sides.DUPLEX); 

PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset); > 
if (services.length > 0) { 
  DocPrintJob job = services[0].createPrintJob(); 

  try {
    job.print(myDoc, aset); 
  } catch (PrintException pe) {
  }
}