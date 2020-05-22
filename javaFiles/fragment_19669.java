public class OuterClass{
    // fields, constructors, methods etc..

    private class MyPanel extends JPanel{   
       // fields, constructors, methods etc..

       @Override
       public void paintComponent(Graphics g){
          // paint code
       }

    }
}