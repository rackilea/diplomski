/*
* returns false if s contains a character different from 'a' 'b' or 'c' 
*/
public boolean isStringValid(String s){
     return !Pattern.matches("($^|[^abc]+)",s);
}