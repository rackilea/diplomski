public static void main(String[] args) {
    Argument a = new Argument("a = 40.8" );
    Argument b = new Argument("b = 20.2"); 
    Expression exp = new Expression("e", a, b );
            double v = exp.calculate();
            System.out.println("$$$$$$$$$$$>>>>>>>" + v);

}