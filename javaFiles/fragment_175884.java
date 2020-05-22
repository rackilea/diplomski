Process process = null;
    try {
            process = Runtime.getRuntime().exec("/usr/bin/libreoffice --headless --convert-to pdf:'writer_pdf_Export' --outdir "+ getDestinationDirectory(order)+" "+getInvoiceFilename()+".fodt");
    } catch (IOException ex) {
        Logger.getLogger(Documents.class.getName()).log(Level.SEVERE, null, ex);
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;
    try {
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException ex) {
        Logger.getLogger(Documents.class.getName()).log(Level.SEVERE, null, ex);
    }
    br.close();
    System.out.println("Program terminated!");