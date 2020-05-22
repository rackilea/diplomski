class MyPanel extends JPanel implements ActionListener {  
    private JTextArea screen;  // screen declared here
    private JButton spacebar,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;

    MyPanel() {
      //text screen 
      // JTextArea screen = new JTextArea();  // but re-declared here!
      screen = new JTextArea();   // note the difference?