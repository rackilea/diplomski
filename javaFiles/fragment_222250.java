File file = new File(outputFile);
BufferedWriter output = null;
output = new BufferedWriter(new FileWriter(file));
output.write(info);
System.out.println("The output file: " + outputFile + " has been written.");
output.close();