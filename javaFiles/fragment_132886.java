class Saver implements ActionListener {
    public void actionPerformed(ActionEvent e) {

        try {
            File file = new File("projekat");
            if (!file.exists()) {
                file.createNewFile();

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                // get latest contents of the JTextArea
                tekst1 = area.getText();

                bw.write(tekst1);
                bw.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}