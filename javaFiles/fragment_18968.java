try {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {                
            String line = scanner.nextLine();
            String array[] = line.split(",");
            Student student  = new Student (array[0],array[1]);
            -------------------------
            -------------------------
            System.out.println("FirstName:"+ array[0]);
            System.out.println("LastName:"+ array[1]);
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }