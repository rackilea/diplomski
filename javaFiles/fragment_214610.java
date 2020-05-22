public class GenericClass<T extends JComponent>{

     private T component;
     public void showComponent(){
            T.setVisible(true);  //you can call this method. T could be a JComponent or a subclass of it
     }
}