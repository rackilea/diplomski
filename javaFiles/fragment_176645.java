public class Map extends java.awt.Panel implements Serializable
    {      
    String width =  JOptionPane.showInputDialog("Give Width (>5 , <30)");
    int w = Integer.parseInt(width);

    String height =  JOptionPane.showInputDialog("Give height (>5 , <30)");
    int h = Integer.parseInt(height);

    GridCell gridCell[][] = new GridCell[w][h];

    public Map()
    {
    super();
    setLayout(new GridLayout(w,h)); 

    if ( w < 5)
    {JOptionPane.showMessageDialog ( null, "Number out of Limits ,application closing" );
     System.exit(0);}
    if ( w > 30)
    {JOptionPane.showMessageDialog ( null, "Number out of Limits ,application closing" );
     System.exit(0);}
    if ( h < 5)
    {JOptionPane.showMessageDialog ( null, "Number out of Limits ,application closing" );
     System.exit(0);}
    if ( h > 30)
    {JOptionPane.showMessageDialog ( null, "Number out of Limits ,application closing" );
     System.exit(0);}


        for(int i=0;i<w;i++){ 

            for(int j=0;j<h;j++){
               gridCell[i][j] = new GridCell();
               gridCell[i][j].setPosition(new Point(i,j));
               add(gridCell[i][j]);
            }
        }
    }