DecimalFormat df = new DecimalFormat("#.000");

double b = Math.pow(43.473684210526315, 10);

String bFormatted = df.format(b);

System.out.println(bFormatted);