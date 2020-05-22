BufferedReader in = null;
    String line;
    DefaultListModel listModel = new DefaultListModel();
    try {
        in = new BufferedReader(new FileReader("C:\\users\\me\\desktop\\blah.txt"));
        while ((line = in.readLine()) != null) {
            listModel.addElement(line); //(String.valueof(line));
        }
    } catch (IOException ex) {
        Logger.getLogger(Frame2.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (in != null) {
            in.close();
        }
    }
    JList jList1 = new JList(listModel);