public static void main(String[] args) {
            FileReader file_reader = null;
        try {
            new Notepad().setVisible(true);
            file_reader = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(file_reader);
            String temp = "";
            while (br.ready())
            {
                int c = br.read();
                temp = temp+ (char)c;
            }
            myarea.setText(temp);
            br.close();
            file_reader.close();
            textContent = myarea.getText();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
}