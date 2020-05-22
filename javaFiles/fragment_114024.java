button1.addActionListener(new ActionListener()                                  
{                                                                               
    public void actionPerformed(ActionEvent e)                                  
    {                                                                           
        SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>()              
        {                                                                       
            @Override                                                           
            protected Void doInBackground() throws Exception                    
            {                                                                   
                Robot robot = new Robot();                                      
                start = true;                                                   
                System.out.println("Pressed");                                  

                while (start)                                                   
                {                                                               
                    robot.keyPress(KeyEvent.VK_W);                              
                    Thread.sleep(1);                                            
                    robot.keyRelease(KeyEvent.VK_W);                            
                    Thread.sleep(150);                                          
                    robot.keyPress(KeyEvent.VK_S);                              
                    Thread.sleep(1);                                            
                    robot.keyRelease(KeyEvent.VK_S);                            
                    Thread.sleep(150);                                          
                    robot.keyPress(KeyEvent.VK_A);                              
                    Thread.sleep(1);                                            
                    robot.keyRelease(KeyEvent.VK_A);                            
                    Thread.sleep(150);                                          
                    robot.keyPress(KeyEvent.VK_D);                              
                    Thread.sleep(1);                                            
                    robot.keyRelease(KeyEvent.VK_D);                            
                    Thread.sleep(150);                                          
                }                                                               
                return null;                                                    
            }                                                                   
        };                                                                      
        sw.execute();                                                           
    }                                                                           
});