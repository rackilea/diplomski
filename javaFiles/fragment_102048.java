String headerFormat = "<tr><th>%8s</th><th>%8s</th><th>%8s</th><th>%8s%n</th></tr>";
String rowFormat = "<tr><td>%8s</td><td>%8s</td><td>%8s</td><td>%8s%n</td></tr>";

pw.printf(headerFormat, "Col A", "Col B", "Col C", "Col XY");
pw.printf(rowFormat, "A", "19", "Car", "55");
pw.printf(rowFormat, "X", "21", "Train C", "-4");
pw.printf(rowFormat, "B", "-9", "Bike", "0");

String message = "<table>" + sw.toString() + "</table>";
System.out.println(message);