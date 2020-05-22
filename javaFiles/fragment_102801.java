class Prog2 {
  public static void main(String args[]) {
    int row, col = 0;
    double average, total = 0;
    int[][] y = {{85,83,77,91,76},
                {80,90,95,93,48},
                {78,81,11,90,73},
                {92,83,30,69,87},
                {23,45,96,38,59},
                {60,85,45,39,67},
                {77,31,52,74,83},
                {93,94,89,77,97},
                {79,85,28,93,82},
                {85,72,49,75,63}
                };

    String[] names = {"Johnson" , "Aniston" ,"Cooper", "Gupta", "Blair", "Clark", "Kennedy", "Bronson", "Sunny", "Smith"};

    System.out.println("Name \t\tS1 \tS2 \tS3 \tS4 \tS5 \tAverage \tGrade ");
    for(row=0; row<=9; row++) {
      System.out.print(names[row] + "\t\t");
      total = 0;
      for(col=0; col<=4; col++) {
        System.out.print(y[row][col] + "\t");
        total = total + y[row][col];
      }
      average = total/5;
      System.out.println(average + "\t\t" + getGrade(average));
    }
  }

  public static String getGrade(double average) {
    if(average > 97) {
      return "A+";
    } else if (average > 93) {
      return "A";
    } else if (average > 90) {
      return "A-";
    } else if (average > 87) {
      return "B+";
    } else if (average > 83) {
      return "B";
    } else if (average > 80) {
      return "B-";
    } else if (average > 77) {
      return "C+";
    } else if (average > 73) {
      return "C";
    } else if (average > 70) {
      return "C-";
    } else if (average > 67) {
      return "D+";
    } else if (average > 63) {
      return "D";
    } else if (average > 60) {
      return "D-";
    } else {
      return "F";
    }
  }
}