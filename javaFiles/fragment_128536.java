public void openPdf(String pdf){
        if (Desktop.isDesktopSupported())   
        {   
            InputStream jarPdf = getClass().getClassLoader().getResourceAsStream(pdf);

            try {
                File pdfTemp = new File("52502HPA3_ELECTRA_PLUS_Fra.pdf");
                // Extraction du PDF qui se situe dans l'archive
                FileOutputStream fos = new FileOutputStream(pdfTemp);
                while (jarPdf.available() > 0) {
                      fos.write(jarPdf.read());
                }   // while (pdfInJar.available() > 0)
                fos.close();
                // Ouverture du PDF
                Desktop.getDesktop().open(pdfTemp);
            }   // try

            catch (IOException e) {
                System.out.println("erreur : " + e);
            }   // catch (IOException e)
        }
    }