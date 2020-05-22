for(int i = 0; i <= level; i++){
        level1 = -1;
        while (level1 < 0 || level1 > 100) {
            System.out.println("Please enter your grade for level " + i);
            level1 = s.nextInt();
        }
        grades.add((double) level1);
    }