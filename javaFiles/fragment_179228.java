public static void main(String args[]) throws Exception { 
    new JFrame(){{  
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        setSize(300,300);  
        setLocation(100,100);  
        setVisible(true);  
        setLayout(new BorderLayout());  
        add(new JButton("PressToOpenNewFrame"){{  
           addActionListener(new ActionListener(){  
           public void actionPerformed(ActionEvent e) {  
               new JFrame(){{  
                   setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
                   setSize(300,300);  
                   setLocation(200,200);  
                   setVisible(true);  
                   setLayout(new BorderLayout());  
                   add(new JButton("PressMeToBeep"){{  
                      addActionListener(new ActionListener(){  
                      public void actionPerformed(ActionEvent e) {  
                         Toolkit.getDefaultToolkit().beep();  
                      }});  
                   }}, BorderLayout.SOUTH);  
               }};  
           }});  
        }}, BorderLayout.SOUTH);  
    }};  
}