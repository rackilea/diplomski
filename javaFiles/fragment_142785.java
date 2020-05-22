public class translate extends JFrame implements ActionListener{
/*
    Our Langauges of choice we can add more if desired in the future 
    */
    DaWord mainArea = new DaWord();
    JMenuBar mainBar;
    JMenu menu;
    JMenuItem main,saveAs;

    String[] nativeString = { "Auto-Detect"};
    String[] translateString = { "Español", "中文", "Francais", "Italiano", "Deutsche" , "English" };
     JComboBox nativeLanguage;
     JComboBox translateTo;
     JButton execute;
      final JPanel topRight;
      final JPanel topLeft;
      final JPanel bottomLeft;
      JPanel bottomRight;
      JLabel tR;
       JLabel tL;
      JLabel bR;
       JLabel bL;
      JScrollPane scroll1;
      JScrollPane scroll2;

      JRadioButton local;
      JRadioButton mainAreas;
      JTextArea input;
      JTextArea output;

    public translate() throws Exception{

      super("Translation Service");
      JOptionPane.showMessageDialog(null, "Translation Services Require A NetWork Function To Make Calls");
      Translate.setClientId("MYID");
      Translate.setClientSecret("shhItsASecret");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setSize(900,450);
      setLocationRelativeTo(null);
      setResizable(true);
      setLookAndFeel();
      SpringLayout spring = new SpringLayout();
      setLayout(spring);
  javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
  setBackground(new Color(128, 218, 235));
      TitledBorder title1 = BorderFactory.createTitledBorder(blackline, "Input Text"); 
      mainBar = new JMenuBar();
      menu = new JMenu("Options");

      main = new JMenuItem("Export To Main");
      saveAs = new JMenuItem("Save As");
      menu.add(main);
      menu.add(saveAs);
      mainBar.add(menu);
     // add(mainBar);

     input= new JTextArea(35,35);
    scroll1 = new JScrollPane(input);
    //  scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //add("Center", scroll1);
     input.setEditable(true);
     input.setLineWrap(true);
  execute = new JButton("Translate");
    execute.addActionListener(this);

    TitledBorder title2 = BorderFactory.createTitledBorder(blackline, "Output Text");                   
     output = new JTextArea(35,35);
     scroll2 = new JScrollPane(output);
      // scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
     scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

     output.setEditable(true);
     output.setLineWrap(true);
     output.setVisible(true);
      /*
      Our JComboBoxes for user to selct langauge they want to choose
      */
      nativeLanguage = new JComboBox(nativeString);
      translateTo = new JComboBox(translateString);

      nativeLanguage.addActionListener(this);
      translateTo.addActionListener(this);
      // JLabels

      tR = new JLabel("Auto-Detect");
      tL = new JLabel ("Target Langauge");
      //  0,2 (2) rows across
     GridLayout flo = new GridLayout(0,2);
     setLayout(flo);
      // setLayout(fl);
      //1
       topRight = new JPanel();
      // topRight.setLayout(new BoxLayout(topRight, BoxLayout.PAGE_AXIS));
       topRight.add(nativeLanguage);
       topRight.add(tR);


       //2
       topLeft = new JPanel();
      // topLeft.setLayout(new BoxLayout(topLeft, BoxLayout.PAGE_AXIS));
       topLeft.add(translateTo);
       topLeft.add(tL);

       //3

      bottomRight = new JPanel();
     // bottomRight.setLayout(new BoxLayout(bottomRight, BoxLayout.PAGE_AXIS));
      bottomRight.add(input);

       //4
      bottomLeft = new JPanel();
    //  bottomLeft.setLayout(new BoxLayout(bottomLeft, BoxLayout.LINE_AXIS));
     bottomLeft.add(output);



     setJMenuBar(mainBar);
     add(topRight);
     add(topLeft);
     add(bottomRight);
     bottomRight.setBorder(title1);
     add(bottomLeft);
     bottomLeft.setBorder(title2);

   setVisible(true);


  saveAs.addActionListener(new java.awt.event.ActionListener(){
 public void actionPerformed(java.awt.event.ActionEvent evt){
        try {
            saveAsActionPerformed(evt);
        } catch (Exception ex) {
            Logger.getLogger(DaWord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveAsActionPerformed(ActionEvent evt) throws Exception{
        Object trans = evt.getSource();
        if(trans==saveAs){
          save();
        }
    }
    private void save() throws FileNotFoundException {

       JFileChooser js2 = new JFileChooser();
       js2.setDialogTitle("Save As");
       js2.setCurrentDirectory(new File ("./"));
       int result = js2.showSaveDialog(null);
       if (result == JFileChooser.APPROVE_OPTION){
       String in1 = "This Is My Original Text:\n\n\n";
       String in2 = "This Is My Translated Text:\n\n\n";
       String content1 = input.getText();
       String content2 = output.getText();
       // all put in one
       String completa = in1+content1+in2+content2;
       File nef = js2.getSelectedFile();
       PrintWriter fw = new PrintWriter(nef.getPath());
       fw.write(completa);
       fw.flush();

       }   
          }

});
  main.addActionListener(new java.awt.event.ActionListener(){
  public void actionPerformed(java.awt.event.ActionEvent evt){
        try {
            mainActionPerformed(evt);
        } catch (Exception ex) {
            Logger.getLogger(DaWord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mainActionPerformed(ActionEvent evt) throws Exception{
        Object mainS = evt.getSource();
        if(mainS==main){
          transfer();
        }
    }

          private void transfer() {
           String original = input.getText();
            String trans = output.getText();


            String intro1 = "This Is Your Original Text Below:\n\n\n";
            String intro2 = "This Is Your Translated Text Below:\n\n\n";


            mainArea.userField.append(intro1+original);
            mainArea.userField.append(intro2+trans);

          }

});





    }

  @Override
    public void actionPerformed(ActionEvent e) {

    Object source = e.getSource();
    /*
       JComboBox translateTo = (JComboBox)e.getSource();
    String box1 = (String) translateTo.getSelectedItem();

    */

   JComboBox nativeLanguage = (JComboBox) e.getSource();
   String newSelection = (String) translateTo.getSelectedItem();

   if (newSelection =="Español"){

        try { 
            eng2spanish();
        } catch (Exception ex) {
            Logger.getLogger(translate.class.getName()).log(Level.SEVERE, null, ex);
        }
}else if(newSelection=="Italiano"){
        try {
            eng2ital();
        } catch (Exception ex) {
            Logger.getLogger(translate.class.getName()).log(Level.SEVERE, null, ex);
        }
}else if(newSelection=="Francais"){
        try {
            eng2french();
        } catch (Exception ex) {
            Logger.getLogger(translate.class.getName()).log(Level.SEVERE, null, ex);
        }
}else if(newSelection=="中文"){
        try {
            eng2chin();
        } catch (Exception ex) {
            Logger.getLogger(translate.class.getName()).log(Level.SEVERE, null, ex);
        }
}else if(newSelection=="Duetche"){
        try {
            eng2ger();
        } catch (Exception ex) {
            Logger.getLogger(translate.class.getName()).log(Level.SEVERE, null, ex);
        }


}else if(newSelection =="English"){
        try {
            eng2eng();
        } catch (Exception ex) {
            Logger.getLogger(translate.class.getName()).log(Level.SEVERE, null, ex);
        }
   }



    }


private void setLookAndFeel() {
try{
UIManager.setLookAndFeel("UIManager.getSystemLookAndFeelClassName");
}catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
UnsupportedLookAndFeelException e){
}
} 

      private void eng2spanish() throws Exception {

String userIn = input.getText();
 String spanishTranslation = Translate.execute(userIn, Language.SPANISH);
output.setText(spanishTranslation);
System.out.println(spanishTranslation);


    }

    private void eng2french() throws Exception { 

String userIn = input.getText();
 String frenchTranslation = Translate.execute(userIn, Language.FRENCH);
output.setText(frenchTranslation);

    }

    private void eng2chin() throws Exception {

String userIn = input.getText();
 String chinTranslation = Translate.execute(userIn, Language.CHINESE_TRADITIONAL);
output.setText(chinTranslation);

    }

    private void eng2ger() throws Exception {

String userIn = input.getText();
 String germanTranslation = Translate.execute(userIn, Language.GERMAN);
output.setText(germanTranslation);

    }



    private void eng2ital() throws Exception {

String userIn = input.getText();
 String italianTranslation = Translate.execute(userIn, Language.ITALIAN);
output.setText(italianTranslation);

    }
        private void eng2ind() throws Exception {

String userIn = input.getText();
 String hindiTranslation = Translate.execute(userIn, Language.HINDI);
output.setText(hindiTranslation);

    }

    private void eng2eng() throws Exception {

String userIn = input.getText();
 String engTranslation = Translate.execute(userIn, Language.ENGLISH);
output.setText(engTranslation); 
    }
}