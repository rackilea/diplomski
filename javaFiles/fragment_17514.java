class firstPokemonChoose extends JFrame{
    private static final int WIDTH = 800; //ukuran panjang window
    private static final int HEIGHT = 800; //ukuran lebar window
    JLabel intro, tryImage;

    public firstPokemonChoose(){
        setTitle("Choose Your Pokemon"); //set judul window
        setSize(WIDTH, HEIGHT); //set ukuran
        intro = new JLabel("Please choose your first Pokemon", SwingConstants.LEFT);
        tryImage = new JLabel(); // initialize the tryImage label
        java.net.URL url = getClass().getResource("/Resources/torchic.png");
        ImageIcon img = new ImageIcon(url);
        tryImage.setIcon(img);

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        pane.add(intro);
        pane.add(tryImage);

        setVisible(true); //set windows visible
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        validate();
    }

    public static void main(String [] args){
        firstPokemonChoose firstPokemonChooseInstance = new firstPokemonChoose();
    }
}