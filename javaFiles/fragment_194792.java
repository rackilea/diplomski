double a = Double.parseDouble(some user input);
double b = Double.parseDouble(some user input);
String operation = some user input; // i.e. "add", "subtract"
Method operator = Calculations.class.getMethod(operation, double.class, double.class);
// NoSuchMethodException is thrown if method of operation name isn't found
double result = (Double) operator.invoke(null, a, b);