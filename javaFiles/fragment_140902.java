StringWriter sw = new StringWriter();
PrintWriter pw = new PrintWriter(sw);

pw.println("Hello");            // Appends two
pw.println("World");            // separate lines

pw.printf("Hello %d World", 5); // Using printf

pw.println();                   // appends a new-line
pw.print("Another line.");      // appends string w/o new-line

pw.println();                   // appends two
pw.println();                   // newlines

String rowFormat = "%8s %8s %8s %8s %8s%n";
pw.printf(rowFormat, "Col A", "Col B", "Col C", "Col XY", "Col De", "Col Ef");
pw.printf(rowFormat, "A", "19", "Car", "55", "Blue", "Last");
pw.printf(rowFormat, "X", "21", "Train C", "-4", "Red", "Demo");
pw.printf(rowFormat, "B", "-9", "Bike", "0", "Green", "Column");

String message = sw.toString();

System.out.println(message);