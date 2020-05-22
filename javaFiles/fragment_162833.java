public class CPanel extends JPanel {
    private JScrollPane scrollPane ;
    private JPanel content ;
    private JEditorPane demo ;

    public CPanel(){

        scrollPane = new JScrollPane() ;
        content = new JPanel() ;
        scrollPane.setViewportView(content); 
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        try{
         java.net.URL text = CPanel.class.getResource("demo.txt") ;
        demo = new JEditorPane(text) ;
        }catch(Exception e){
            System.out.println("Something bad happened with the file") ;
        }

        //These need to be added to the contentpanel
        content.add(demo) ;
        JButton demob = new JButton("Button 1") ;
        JButton demob2 = new JButton("Button 2") ;
        content.add(demob) ;
        content.add(demob2) ;

        //Here we need to add the scrollPane, to which the JPanel 
        //with BoxLayout has been added
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
    }
}