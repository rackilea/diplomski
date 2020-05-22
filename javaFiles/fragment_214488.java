JLabel l=new JLabel("My Documents");
l.setIcon(new ImageIcon("mydocuments.png"));

l.setHorizontalTextPosition(SwingConstants.CENTER);
l.setVerticalTextPosition(SwingConstants.BOTTOM);
l.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                if(me.getClickCount()==2)
                {
                    try
                    {
                        Desktop.getDesktop().open(new File(System.getProperty("user.home")+"\\My Documents"));
                    }catch(Exception e){}
                }
            }
        });