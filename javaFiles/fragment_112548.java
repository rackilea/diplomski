private JPanel drawPanel; //don't forget to create a proper one! override paint in that panel!
private int a,b,c;
public QuadraticPanel(){ //constructor
    setLayout(new BoderLayout();
    JSlider aSidler = new JSlider();
    slider.addChangeListener(new ChangeListener(){
        @Override
        public void stateChanged(ChangeEvent arg0) {
              a = arg0.getValue(); //setting a value
              //it might even be better to calculate the value
              //BEFORE you redraw
              //recalcEquotiation()
              drawPanel.repaint(); //and redraw the paint-panel
        }           
    });
    add(aSlider, Borderlayout.WEST); //add more sliders with better layouts or subcomponents
    add(drawPanel, BorderLayout.CENTER);
 }