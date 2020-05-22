public static PrintStream showSaveDialog() {
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Tekst filer", "txt");
      chooser.setFileFilter(filter);

      int returnVal = chooser.showSaveDialog(null);
      try {
         if (returnVal == JFileChooser.APPROVE_OPTION) {

            //  ******* note changes below *****
            File file = chooser.getSelectedFile();

            FileOutputStream fos = new FileOutputStream(file, true);
            return new PrintStream(fos);
         } else {
            return null;
         }
      } catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Ugyldig Fil!", "error",
               JOptionPane.ERROR_MESSAGE);
      }
      return null;

   }