if (Desktop.isDesktopSupported()) {
                    try {
                        File myFile = new File("C:\\Users\\klinks\\Documents\\pdf.pdf");
                        Desktop.getDesktop().open(myFile);
                    } catch (IOException e) {
                        // System probably doesn't have a default PDF program
                    }
                }