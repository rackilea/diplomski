public class Gpa {

    private int[] credits;
    private String[] grades;
    private int currentGrade;

    public Gpa(int numGrades) {
        credits = new int[numGrades];
        grades = new String[numGrades];
        currentGrade = 0;
    }

    public void addGrade(String letterGrade, int credit) {
        grades[currentGrade] = letterGrade;
        credits[currentGrade] = credit;
        currentGrade = currentGrade + 1;
    }

    public double getGpa() {
        double totalPoints = 0;
        double totalWeight = 0;

        for (int i = 0; i < currentGrade; i++) {
            totalPoints = totalPoints + (letterToGpa(grades[i]) * credits[i]);
            totalWeight = totalWeight + credits[i];
        }

        return totalPoints / totalWeight;
    }

    private double letterToGpa(String letter) {
        char first = letter.toUpperCase().charAt(0);
        switch (first) {
            case 'A':
                return 4.0;
            case 'B':
                return 3.0;
            case 'C':
                return 2.0;
            case 'D':
                return 1.0;
        }
        return 0.0;
    }
}