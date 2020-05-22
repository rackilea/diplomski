(...)
// 1) Create your image;
final ImageIcon image = new ImageIcon("../folder/myImage.gif");

//2) Create a JPanel with a background image;
  JPanel  myPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g)
            {
                g.drawImage(image.getImage(), 0, 0, null);
            }
    };

//3) Add panel 
getContentPane().add(myPanel);

(...)