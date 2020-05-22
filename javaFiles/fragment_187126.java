private static void updateLine(String fails, String ID, String toUpdate, String updated) {
    // Try With Resources is used to autoclose the BufferedReader
    try (BufferedReader file = new BufferedReader(new FileReader(fails))) {
        String line;
        String input = "";
        while ((line = file.readLine()) != null) {
            if (line.equals(ID)) {
                // Append the ID to String
                input+= ID + System.lineSeparator(); 
                /* Loop through this client's data and make 
                   changes where necessary...   */
                while ((line = file.readLine()) != null) {
                    /* If we get to this point where we read an ID again
                       then we've gone too far. The item to update could
                       not be found under the supplied ID Number.  */
                    if (line.startsWith("ID:")) {
                        // Append the original ID to String.
                        System.out.println("The item to update (" + toUpdate + 
                                ") could not be found under the ID of: " + ID);
                        // Add this line to string anyways.
                        input+= line + System.lineSeparator();
                        break; // Break out of this inner lop
                    }
                    // Does file line match the supplied toUpdate?
                    if (line.equals(toUpdate)) {
                        // Yes - Append the new item to String
                        input+= updated + System.lineSeparator();
                        break; // Get out of inner loop. Let main loop take over again.
                    }
                    else {
                        // Append the original item to String.
                        input+= line + System.lineSeparator();
                    }
                }
            }
            else {
                input+= line + System.lineSeparator();
            }
        }   
        // Re-Write File with new data
        // Try With Resources is used to autoclose the Stream
        try (FileOutputStream os = new FileOutputStream(fails)) {
            os.write(input.getBytes());
            os.flush();
        }
    }
    catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
}