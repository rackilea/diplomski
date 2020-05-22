if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) 
    {
      java.io.File file = fileChooser.getSelectedFile();
      FileOutputStream fileOut = new FileOutputStream(file);
      wb.write(fileOut);

      fileOut.close();
    }