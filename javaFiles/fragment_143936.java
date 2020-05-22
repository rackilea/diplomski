int [] [] students_grades = new int[2][3];
        students_grades[0][0] = 13;
        students_grades[0][1] = 23;
        students_grades[0][2] = 34;

        students_grades[1][0] = 31;
        students_grades[1][1] = 32;
        students_grades[1][2] = 43;

        int rows = 2;
        int columns = 3;
        int i, j;
        List<Integer> myList = new ArrayList<Integer>();

        for (i = 0; i < rows; i++) {
            for ( j = 0; j < columns; j++) {
                myList.add(students_grades[i][j]);
                if (myList.size() == 3) {
                    System.out.println("************************************************");
                    System.out.println("This is the grades for Students 1: ");                 System.out.println("-------------------------------------------------");
                    for (int element : myList) {
                        System.out.println(element);
                    }
                }
            }
            System.out.println(" ");
        }

    }