class PanelTitle implements ActionListener{
    String title;
    private SedimentPanel sp;

    public PanelTitle(SedimentPanel sp){  // pass in reference
        this.sp = sp;
    }

    @Override
    public void actionPerformed(ActionEvent ae){
         sp.setTitle("SEDIMENT"); // better to give the class this method
    }
}