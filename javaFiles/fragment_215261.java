double plusReal = (-b) / (double)(2 * a);
double minusReal = (-b) / (double)(2 * a);

double plusImaginary = Math.sqrt(-1 * imaginaryCheck) / (2 * a);
double minusImaginary = -Math.sqrt(-1 * imaginaryCheck) / (2 * a);

System.out.format("Your first solution is: %1.2f + %1.2fi\n", plusReal, plusImaginary);
System.out.format("Your second solution is: %1.2f + %1.2fi", minusReal, minusImaginary);