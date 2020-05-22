BufferedImage[][] tex=new BufferedImage[16][16];
BufferedImage towie;
int map[][]=new int[30][3000];
int cX=15,cY=15;
class Dea extends JPanel
{
    Dea()
    {

    new ImagesLoader();

//            setBackground(Color.BLACK);
//            setLayout(null);
        for(int i=11;i<30;i++)
        {
            for(int j=0;j<3000;j++)
            {
                map[i][j]=0;
            }
        }
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<3000;j++)
            {
                map[i][j]=815;
            }
        }
        Random r=new Random();
        for(int j=0;j<3000;j++)
        {
            map[9][j]=3;
            int randomNum = r.nextInt(1+ 1);
            map[10][j]=2;
            if(randomNum==0)map[11][j]=2;
            randomNum = r.nextInt(3 + 1);
            if(randomNum==1&&map[11][j]==2)map[12][j]=2;
        }
        addKeyListener(new KeyListener(){
            public void keyReleased(KeyEvent e) { }
            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e)
              {
              System.out.println("keys");
                int c1=cX;
                int c2=cY;
                  int keyCode = e.getKeyCode();
                  char key=e.getKeyChar();
                    switch( keyCode ) { 
                    case KeyEvent.VK_UP:
                        cY++; 
                        break;
                    case KeyEvent.VK_DOWN:
                        cY--;
                        break;
                    case KeyEvent.VK_LEFT:
                        cX--;
                        break;
                    case KeyEvent.VK_RIGHT :
                        cX++;
                        break;
                 }
                    switch( key ) { 
                    case 's':
                    case 'S':
                        cY++; 
                        System.out.println(cX+" "+cY);
                        break;
                    case 'w':
                    case 'W':
                        cY--;
                        System.out.println(cX+" "+cY);
                        break;
                    case 'a':
                    case 'A':
                        cX--;
                        System.out.println(cX+" "+cY);
                        break;
                    case 'd':
                    case 'D':
                        cX++;
                        System.out.println(cX+" "+cY);
                        break;
                 }
//                        if(cX<0||cX>2999)cX=c1;
//                        if(cY<0||cY>30)cY=c2;
                    repaint();
              }
            });
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(towie,0,0, this);
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[0].length;j++)
            {   
                g.drawImage(tex[map[i][j]/100][map[i][j]/100],cX+j*20,cY+i*20,this);
            }
        }
    }
}