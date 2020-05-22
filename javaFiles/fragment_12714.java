try ( BufferedReader inFile = new BufferedReader(new FileReader(f))) {
        Student student;
        while ( ( student = Student.load(inFile)) != null) {
            students.add(student);
        }
    } catch (FileNotFoundException e) {
        System.err.println( "Could not open file for reading.");
        return;
    } catch (IOException e) {
        System.err.println( "An error occured while reading from the file.");
    }