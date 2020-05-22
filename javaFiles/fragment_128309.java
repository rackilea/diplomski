class cPrint implements PrivilegedAction<Object> {
 String str;
 PrintService service;

 public cPrint(String str, PrintService argPrintService) {

    this.str = str;
    this.service = argPrintService;

 };
 public Object run() {
    // privileged code goes here
    InputStream is = null;
    try 
    {
        JOptionPane.showMessageDialog(null, "String is:::"+str);
        byte[] Originalbytes = str.getBytes();
        JOptionPane.showMessageDialog(null, "Original bytes:::"+Originalbytes);
        is=new ByteArrayInputStream(Originalbytes);
        FileWriter fstream = new FileWriter("/home/test/out.pdf");  
        BufferedWriter out = new BufferedWriter(fstream);  
        for (Byte b: Originalbytes) {  
            out.write(b);  
        }  
        out.close();
        DocPrintJob printJob = service.createPrintJob();
        Doc doc;
        DocAttributeSet docAttrSet = new HashDocAttributeSet();
        PrintRequestAttributeSet printReqAttr = new HashPrintRequestAttributeSet();
        doc = new SimpleDoc(is, DocFlavor.INPUT_STREAM.AUTOSENSE, docAttrSet);
        PrintJobWatcher pjDone = new PrintJobWatcher(printJob);
        printJob.print(doc, printReqAttr);
        pjDone.waitForDone();
        // It is now safe to close the input stream
        is.close();
     } 
     catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
        return 1;
     } 
    return 0;
  }
  static class PrintJobWatcher {
    // true iff it is safe to close the print job's input stream
    boolean done = false;

    PrintJobWatcher(DocPrintJob job) {
        // Add a listener to the print job
        job.addPrintJobListener(new PrintJobAdapter() {
            public void printJobCanceled(PrintJobEvent pje) {
                allDone();
            }
            public void printJobCompleted(PrintJobEvent pje) {
                allDone();
            }
            public void printJobFailed(PrintJobEvent pje) {
                allDone();
            }
            public void printJobNoMoreEvents(PrintJobEvent pje) {
                allDone();
            }
            void allDone() {
                synchronized (PrintJobWatcher.this) {
                    done = true;
                    PrintJobWatcher.this.notify();
                }
            }
        });
    }
    public synchronized void waitForDone() {
        try {
            while (!done) {
                wait();
            }
        } catch (InterruptedException e) {
        }
    }
 }
}