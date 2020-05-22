package test;

public class CircleExercise {

    public static void main(String[] args) {
        // you must increment the variable in 2 units
        for(int i = 0 ; i < 3 ; i+=2) {

            Circle kreis = new Circle();

            // and select different indexes: i and i+1
            double radius = Double.parseDouble(args[i]);
            boolean filled = Boolean.parseBoolean(args[i+1]); 

            System.out.println(i + ". Kreis:\nRadius: " + radius + "\nUmfang: " + kreis.getCircumference(radius) + "\nFlaeche: " + kreis.getArea(radius));
            if (filled == true){
                System.out.println(i + ". Kreis ist gefuellt.");
            }
            else 
                System.out.println(i + ". Kreis ist nicht gefuellt.\n");
        }
    }
}