class DamClass1 {
   JTextField searchfield = new JTextField(10);
   JPanel panel = new JPanel();

   public DamClass1() {
      panel.add(new JLabel("Search:"));
      panel.add(searchfield);
      panel.setLayout(new GridLayout(5, 2));
      int result = JOptionPane.showConfirmDialog(null, panel, "Search",
            JOptionPane.YES_NO_OPTION);
      if (result == JOptionPane.YES_OPTION) {
         DamClass2 c2 = new DamClass2();
         String stringSearch = searchfield.getText();

         if (stringSearch.equals("Foo")) {
            c2.setField1(stringSearch);
            c2.setField2("Bar");

            int result2 = JOptionPane.showConfirmDialog(panel, c2.getPanel(),
                  "Search found", JOptionPane.YES_NO_OPTION);
         }

         // commented to make the code runnable for me.
         // try {
         // BufferedReader bf = new BufferedReader(new FileReader("file.txt"));
         // int linecount = 0;
         // String line;
         // ArrayList<String> list = new ArrayList<String>();
         // while ((line = bf.readLine()) != null) {
         // list.add(line);
         // linecount++;
         // int indexfound = line.indexOf(stringSearch);
         // if (indexfound > -1) {
         // String[] word = line.split("\t");
         // String firstword = word[0];
         // String secondword = word[1];
         // c2.field1.setText(stringSearch);//This is the problem
         // c2.field2.setText(secondword);//This is the problem
         // }
         // }
         // bf.close();
         // } catch (IOException e) {
         // System.out.println("IO Error Occurred: " + e.toString());
         // }
      }
   }

   public static void main(String[] args) {
      DamClass1 s1 = new DamClass1();
   }
}