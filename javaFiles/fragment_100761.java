String s = "Total Count :2, Correct Count :1,Wrong Count:1, Correct :India is great,, Wrong: where aer you";

    String[] ints = s.split("[^0-9]+");

    int totalCount = Integer.parseInt(ints[1]);
    int correctCount = Integer.parseInt(ints[2]);
    int wrongCount = Integer.parseInt(ints[3]);

    System.out.println(totalCount + " " + correctCount + " " + wrongCount); //2 1 1