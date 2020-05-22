String content = Area.getText();

JFileChooser chooser = new JFileChooser();
chooser.setCurrentDirectory(new File("/home"));

int retrieval = chooser.showSaveDialog(null);
if (retrieval == JFileChooser.APPROVE_OPTION) {
    try {
       File dir = new File(chooser.getSelectedFile().toString());
       dir.mkdir();
       System.out.println(chooser.getSelectedFile().toString());
       File file = new File(chooser.getSelectedFile().toString()+ "/temp.txt");

       if (!file.exists()) {
            file.createNewFile();
       }

       FileWriter fw = new FileWriter(file.getAbsoluteFile());
       BufferedWriter bw = new BufferedWriter(fw);
       bw.write(content);
       bw.close();
   }
   catch (Exception ex) {
       ex.printStackTrace();
   }
}