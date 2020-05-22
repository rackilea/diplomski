public void printy(){
    JTextPane jtp = new JTextPane();
    jtp.setBackground(Color.white);
     try {
            //  open the file we have just decrypted

                File myFile = new File(deletefile + "mx.txt");
                FileInputStream fIn = new FileInputStream(myFile);
                BufferedReader myReader = new BufferedReader(
                        new InputStreamReader(fIn));
                String aDataRow = "";
                String aBuffer = "";
                while ((aDataRow = myReader.readLine()) != null) {
                    aBuffer += aDataRow + "\n";
                }   

                String[] splitdata = aBuffer.split("`"); //recover the file and split it based on `
             String lines = "";
            for(String line : splitdata){
            lines = lines + line + System.getProperty("line.separator") + System.getProperty("line.separator");
            }

                myReader.close();

                System.out.println(Arrays.toString(splitdata));
                System.out.println(lines);

                jtp.setText(lines);
                boolean show = true;
                try {
                    //set the header and footer data here
                    MessageFormat headerFormat = new MessageFormat("Your header here - {0}");  //sets the page number
                    MessageFormat footerFormat = new MessageFormat("Your footer here");

                    PrintRequestAttributeSet attr_set = new HashPrintRequestAttributeSet();
                    attr_set.add(MediaSizeName.ISO_A4);
                    attr_set.add(Sides.DUPLEX);

                    jtp.print(headerFormat, footerFormat, show, null, attr_set, show);


                } catch (java.awt.print.PrinterException ex) {
                    ex.printStackTrace();
                }

            } catch (Exception ez) {
                System.out.println("error in array building");
            }

}
}