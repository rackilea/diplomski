JFrame window=new JFrame("Window");
window.addWindowListener(new WindowAdapter(){
     @Override
     public void windowClosed(WindowEvent evt)
     {
         //Do something after window has closed.
     }
     public void windowClosing(WindowEvent evt)
     {
         //Do something when window is closing.
         //Useful when you have to access data in window(buttons, textfields etc)
     }
});