public class YourClass{
//instance variables 
private JComboBox[] petList; // you just declared an array of petList
private static final int PET_SIZE = 4;// assuming
//Constructor
public YourClass(){
 petList = new JComboBox[PET_SIZE];  // here you initialed it
 for(int i = 0 ; i < petList.length; i++){
  //.......
  petList[i] = new JComboBox(); // here you assigned each index to avoid `NullPointerException`
 //........
 }
}}