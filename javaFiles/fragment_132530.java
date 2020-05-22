File ourSrtFile = ourFileSelector.getSelectedFile();
    String srtPath = ourSrtFile.getAbsolutePath();
    ArrayList<String> array = ReadFile.getFileStartingTime(srtPath);
    DefaultListModel model = (DefaultListModel) list.getModel();
    for (String s : array) {
         model.addElement(s);
    }