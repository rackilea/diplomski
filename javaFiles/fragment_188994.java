try {
    output = new java.io.PrintWriter(file); // output is not defined yet
} catch (FileNotFoundException ex) {
    ex.printStackTrace();
        }


// Create a file
// This one will throw the FileNotFoundException
java.io.PrintWriter output = new java.io.PrintWriter(file);