public class Polynomial{
Integer coef[]; 
Integer exp;     
public Polynomial(Integer a, Integer b) {
    coef = new Integer[b+1];
    for (int i = 0; i < coef.length; i++){
       coef[i] = new Integer(0);  //create a new Integer and initialize to zero
    }
    coef[b] = a;
    exp = b;
}