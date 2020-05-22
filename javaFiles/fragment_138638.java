salva.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String text = l1.getText();
          if ( text != null  && !text.isEmpty() )
          {
             String[] lines = text.split("\n");
             BufferedWriter fileOut = new BufferedWriter(new FileWriter("filename.txt"));
             for ( String line : lines )
             {

                fileOut.write( line, 0, line.length()-1 );
                fileOut.newLine();
             }

             fileOut.close();
          }


        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });