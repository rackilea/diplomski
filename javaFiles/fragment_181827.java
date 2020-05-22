DecimalFormat df = new DecimalFormat("###.####") // <- "###.###" specifies precision

double x = 143.13;
double y = 23.12;
double answer = x / y;

System.out.println("Answer: " + df.format(answer));