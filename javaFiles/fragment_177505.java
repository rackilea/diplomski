String filePath = "C:/downloads/stud_records.txt"; // your file path
        /*
         * Gives you a list of all students form the file
         */
        List<Student> allStudentsFromFile = Files.lines(Paths.get(filePath)).map(line -> {
            String[] data = line.split("\\s+"); //Split on your delimiter
            Student stud = new Student(data[0], data[1], Integer.parseInt(data[2]));
            return stud;
        }).collect(Collectors.toList());