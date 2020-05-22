class project extends Frame { // implements ActionListener{

 Highlighter hilit;
 Highlighter.HighlightPainter painter;

JTextArea userField;
JTextField searchT;
JButton searchB;

public project(){


 userField = new JTextArea("spotlight aaa spotlight");
 searchT = new JTextField("spotlight");
 searchT.setEditable(true);
//     searchT.setBorder(new LineBorder (Color.black));

 searchB = new JButton("Search");

    hilit = new DefaultHighlighter();
    painter = new                    DefaultHighlighter.DefaultHighlightPainter(Color.red);





// JButton (searchB) with ActionListener 
 searchB.addActionListener(new java.awt.event.ActionListener(){
public void actionPerformed(java.awt.event.ActionEvent evt) {
    try {
        searchBActionPerformed(evt);
    } catch (BadLocationException ex) {
//            Logger.getLogger(DaWord.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

       private void searchBActionPerformed(ActionEvent evt) throws BadLocationException  {
           Object sb = evt.getSource();
         if(searchB==sb){
       getSearch();

           }

       }
       private void getSearch() throws BadLocationException {

         // my jtextfield
       String jtf = searchT.getText();
        // my jtextarea
        String jta = userField.getText();

        hilit = userField.getHighlighter();
        hilit.removeAllHighlights();


 int index = jta.indexOf(jtf);

while(index >=0){
System.out.println("looping");


System.out.println("im searching for"+jtf+" "+index);
int len = jtf.length();
hilit.addHighlight(index,index+len, painter);
index = jta.indexOf(jtf, index+len);
System.out.println("this is what I want to highlight"+ index);
// remove hightlights with a timer for example after 10 seconds
}

}

});

setSize(500, 500);

setLayout(new FlowLayout());

add(userField);
add(searchT);
add(searchB);

setVisible(true);

}

}