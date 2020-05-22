File f = new File("students.txt");
    if (f.exists()) {
        File backup = new File("students.bak");
        if ( ! f.renameTo(backup) ) {
            System.err.println( "Could not create backup.");
            return;
        }
        f = new File("students.txt");
    }

    try ( PrintWriter outFile = new PrintWriter(f);) {

        for (Student student : students) {
            student.save(outFile);
        }
    } catch (FileNotFoundException e) {
        System.err.println("Could not open file for writing.");
        return;
    }