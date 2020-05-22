public class Vehicle {
     private String id;
     private String name;

     public enum Color {
       RED, GREEN, ANY;
     };

     private Color color;    

     public Color getColor(){
        return color; 
     }

     public void setColor(Color color){
         this.color = color;
     }   

    }