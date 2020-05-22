package StackOverFlow;


import javax.swing.JOptionPane;

class Discriminant{

    public double Discriminant(){
double a, b, c,d;
float e,r,rr;

    String input1 = JOptionPane.showInputDialog("Please, enter the first real number");
    a = Double.valueOf(input1).doubleValue();
    String input2 = JOptionPane.showInputDialog("Please, enter the second real number");
    b = Double.valueOf(input2).doubleValue();
    String input3 = JOptionPane.showInputDialog("Please, enter the third real number");
    c = Double.valueOf(input3).doubleValue();
    d= Math.pow(b,2) - 4*a*c;
    d = Math.round(d*100)/100.0;
    e=(float) Math.sqrt(d);
    r= (float) ((b*(-1) + e)/(2*a));
    r = (float) (Math.round(r*100)/100.0);
    rr= (float) ((b*(-1) - e)/(2*a));
    rr = (float) (Math.round(rr*100)/100.0);  
    System.out.println("You have entered a = " + a + " b = " + b + " c = " + c);
    System.out.println("The quadratic equation is " + a + "x^2 " + b + "x " + c + " = 0" );
    System.out.println("The discriminant is D= " + d + "   D is calculated using the formula D= " + b + "^2 " + " - 4" + "("+ a + ")" + "("+ c + ")");
    if (d>0){
        System.out.println("The roots are " + r + " and " + rr);
    }
    else if (d<0){
        System.out.print("There r not roots.");
    }


    return d;
}
}