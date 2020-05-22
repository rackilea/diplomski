static public Media[] importMedia(String fileName)
{
    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        // Get and process first line:
        String line = reader.readLine(); // <-- Get the first line. You could consider reader as a queue (sort-of), where readLine() dequeues the first element in the reader queue.
        int numberOfItems = Integer.valueOf(line); // <-- Create an int of that line.
        // Do the rest:
        while((line = reader.readLine()) != null) // <-- Each call to reader.readLine() will get the next line in the buffer, so the first time around this will give you the second line, etc. until there are no lines left to read.
        {
             // You will not get the header here, only the rest.
             if(!line.isEmpty() || line.startsWith("#") {
                 // If the line is not empty and doesn't start with a comment character (I chose # here).
                 String[] split = line.split(",");
                 String fileName = split[0];
                 // etc...
             }
        }
    } catch (Exception ex) { System.out.println(ex.getMessage()); }
    return null;
}