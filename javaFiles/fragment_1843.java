class DrawingSpace extends JPanel{

    private JButton button;
    private Timer timer;
    private int idx;
    private Color[] colors;    

    public DrawingSpace(){
        setPreferredSize(new Dimension(200, 200));
        initComponents();
        add(button);    
    }

    public void initComponents(){
        idx = 0;
        colors = new Color[]{Color.RED, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN};
        button = new JButton("Let the colors rock!");
        timer = new Timer(100, new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){
                //Change color every (approx) 100 milliseconds
                idx = (idx + 1) % colors.length;   //cycle through the colours
                setBackground(colors[idx]);
            }               
        });    

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(!timer.isRunning())
                    timer.start();
                else
                    timer.stop();   
            }   
        }); 
    }
}