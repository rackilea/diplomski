try {
        BufferedReader reader = new BufferedReader(new FileReader("file.csv"));

        // Reading first line..
        String[] names = reader.readLine().split(",");
        // Execpt 'names' there are total 4 students, A,B,C,D.
        int totalStudents = names.length - 1;
        StudentVO[] array = new StudentVO[totalStudents];
        // Initialize all students with default constructor.
        for(int i = 0; i < array.length; i++) {
            array[i] = new StudentVO();
        }

        //////////////
        // Start reading other data and setting up on objects..
        // Line 2..
        String[] joinDates = reader.readLine().split(",");
        // i = 0 gives us the string 'joinDates' which is in the first column.
        // so we have to skip it and start it from i = 1
        for(int i = 1; i < joinDates.length; i++) {
            // setting the objects data..
            array[i - 1].setJoinDate(joinDates[i]); 
        }

        // And keep on doing this until SecondLang_Marks..

        reader.close();
    } catch (Exception e) {
        e.printStackTrace();
    }