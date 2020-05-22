try {
    FileWriter outputStream = new FileWriter(filename);
    try (BufferedWriter out = new BufferedWriter(outputStream)) {
        out.write("/*");
        out.newLine();
        out.write(name);
        out.newLine();
        out.write("APCS1 pd" + period);
        out.newLine();
        out.write("HW" + hwnum + " -- " + hwsummary);
        out.newLine();
        out.write(getdate());
        out.newLine();
        out.write("*/");
    }
} catch (IOException ex) {
    // some sort of error message here
    // this block will only be run if the program is unable to create or write to the specified file
}