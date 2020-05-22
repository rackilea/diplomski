snake = new JFrame();
snake.setLayout(new BorderLayout());

//home screen panel
homeScreen = new JPanel(new BorderLayout());
//homeScreen.setLayout(new BoxLayout(homeScreen, BoxLayout.X_AXIS));
homeScreen.setPreferredSize(new Dimension(320, 320)); // probably you need to remove this line!

JLabel bg = new JLabel();
ImageIcon icon = new ImageIcon("HomeBG.gif");
icon.getImage().flush();
bg.setIcon(icon);
homeScreen.add(bg);

easy = new JButton("Easy");
medium = new JButton("Medium");
hard = new JButton("Hard");
play = new JButton("Play");


//button listeners code here
JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
buttonsPanel.add(easy);
buttonsPanel.add(medium);
buttonsPanel.add(hard);
buttonsPanel.add(play);

homeScreen.add(buttonsPanel, BorderLayout.NORTH);

snake.add(homeScreen, BorderLayout.CENTER);
snake.setTitle("Snake Game");
snake.pack();
snake.setVisible(true);
snake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);