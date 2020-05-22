FileOutputStream fileOut = new FileOutputStream(filename);
    wb.write(fileOut);

    fileOut.close();

    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) 
    {
      java.io.File file = fileChooser.getSelectedFile();
      // save to file
    }