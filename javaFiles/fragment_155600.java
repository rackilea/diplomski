Scanner kb = new Scanner(new FileInputStream(new File("d://app//test.txt")));
boolean firstline = true;
        while(kb.hasNext()) {
            if (firstline) {
                title = kb.nextLine();
                firstline = false;
            } else {
                String fName =kb.next() ;
                String lName = kb.next();
                int score1 = kb.nextInt();
                int score2 = kb.nextInt();
                int score3 = kb.nextInt();

                students.add(new Student(fName, lName));
            }
        }