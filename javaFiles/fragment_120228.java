long integersSum = 0; // 'long' data type is used in case the integer values in file(s) are quite large.
int actualFilesProcessed = 0;
String ls = System.lineSeparator();

String[] filePaths = {"C:\\MyFiles\\file1.txt", 
                      "C:\\MyFiles\\file2.txt",
                      "D:\\MyOtherFiles\\SomeFile1.txt",
                      "D:\\MyOtherFiles\\SomeFile2.txt"};

BufferedReader reader;
for (String file : filePaths) {
    try {
        reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim(); // Trim off leading and trailing spaces (if any).

            // Skip lines that are not string representations of a
            // Integer numerical value. The includes blank lines.
            if (!line.matches("\\d+")) {
                continue;
            }

            // Add the value with what is already contained within
            // the integersSum variable:
            integersSum += Integer.parseInt(line);
        }
        reader.close();   // Close the current reader.
    }
    catch (FileNotFoundException ex) {
        System.out.println("Can not locate data file! [" + file + "]" 
                           + ls + "Skipping this data file!" + ls);
    }
    catch (IOException ex) {
        System.out.println("I/O Error with file: " + file + ls + ex.getMessage());
    }

    actualFilesProcessed++;  // Increment files processed counter.
} // End of loop

// Display the results in Console.
System.out.println("The total sum of all intger values found within the " 
                 + actualFilesProcessed + " files processed is: " + integersSum);