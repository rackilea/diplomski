public static void compute( String formula, double[] values ){
    double masse = 0.0;
    String[] formulaHolder = formula.split("(?=[A-Z0-9])");
    double[] massHolder = new double[formulaHolder.length];

    for (int k = 0; k < formulaHolder.length; k++){
        String form = formulaHolder[k];
        if (form.matches("\\d+")){
            double f = Double.parseDouble(form);
             masse += massHolder[k-1]*(f-1);
        } else {
             massHolder[k] = values[k]; // get the value from the db
             masse += massHolder[k];
        }
    }
    System.out.println( masse );
}