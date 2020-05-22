import javax.swing.JOptionPane;

public class NewClass1 {
    public void userInput(int x){



    if (x == 1){
        double radius = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius"));
        System.out.println(circle(radius));


    }else if (x == 2){
        int base = Integer.parseInt(JOptionPane.showInputDialog("Enter the base"));
        int height = Integer.parseInt(JOptionPane.showInputDialog("Enter the height"));
        System.out.println(triangle(base,height));

    }else if (x == 3){
        int side = Integer.parseInt(JOptionPane.showInputDialog("Enter the side"));
        System.out.println(square(side));
    }
}


public static double circle(double radio){

    double circle = (radio * radio) * 3.14159265358; 
    JOptionPane.showMessageDialog(null, "The circle area is "+circle);
    return circle;
}

public static int triangle(int base,int height){
    int triangle = (base * height)/2;
    JOptionPane.showMessageDialog(null, "The triangle area is "+triangle);
    return triangle;
}

public static int square(int side){
    int square = side * side;
    JOptionPane.showMessageDialog(null, "The square area is "+square);
    return square;
}

public static void main(String[] args) {

    NewClass1 obj = new NewClass1();
    int object = Integer.parseInt(JOptionPane.showInputDialog(
    "Enter 1 if you want to know the area of a circle\nEnter 2 if you want to know the area of a triangle.\nEnter 3 if you want to know the area of a square"));
    obj.userInput(object);
}
}