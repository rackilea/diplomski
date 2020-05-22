public class Painting extends JPanel{
   Test test;
   public Painting()
   {
     test = new Test();
     setLayout(new BorderLayout());
     add(test);
   }
}