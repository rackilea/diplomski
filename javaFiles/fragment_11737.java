public class Book{

 private boolean isRented;

 public void borrow(){
     isRented = true; // you change your internal structure and in the new state is borrowed
 }

 public void returned(){
   isRented = false; // the same here
 }

}