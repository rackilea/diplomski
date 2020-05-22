public class Gui2 extends JFrame{

    /**
     * 
     */
    private static final long serialVersionUID = 0;
    private JTextField f[][]= new JTextField[9][9] ;
    private JPanel p[][]= new JPanel [3][3];

    public Gui2(){
        super("Sudoku");

        for(int x=0; x<=8; x++){
            for(int y=0; y<=8; y++){
                f[x][y]=new JTextField(1);
            }
        }

        for(int x=0; x<=2; x++){
            for(int y=0; y<=2; y++){
                p[x][y]=new JPanel(new GridLayout(3,3));
            }
        }

        setLayout(new GridLayout(3,3,5,5));

        for(int u=0; u<=2; u++){
            for(int i=0; i<=2; i++){    
                for(int x=0; x<=2; x++ ){
                    for(int y=0; y<=2; y++){
                        p[u][i].add(f[y+u*3][x+i*3]);
                    }
                }
            add(p[u][i]);
            }
        }
    }
}