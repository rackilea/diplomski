package feetToInches2;


public class Feet2Inches {
    public double feetToInches_ (double feet) {
        return 12* feet;    
    } 

    public int max(int val1, int val2) {
        if (val1 > val2) {
            return (val1);
        } 
        else {
            return (val2);
        }
    }
    public static void main(String[] args) {
        Feet2Inches converter=new Feet2Inches();
        int max = converter.max(100,50);
        double inches = converter.feetToInches_(10.5);
        System.out.println("Max value = " + max);
        System.out.println("Inches = " + inches);
    }

}