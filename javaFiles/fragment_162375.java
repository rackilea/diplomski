class programTwo {


    public static void main (String[] args) {
        if(args.length > 20)
        {
            System.out.println("You entered too many numbers! Fail.");
            return;
        }
        double values[] = new double[args.length];
        for(int i=0; i< args.length; ++i)
            values[i] = Double.valueOf(args[i]);

        System.out.println("Your average is: " + average(values));
    }

    public static double average(double [] values) {
        double average = 0.0;
        for (double value : values) {
            average += value;
        }
        average /= values.length;

        return average;
    }

}