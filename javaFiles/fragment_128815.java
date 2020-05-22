class GradeBook {
    public void displayMessage() { // removed semi colon from your code
        System.out.println("Welcome to the Grade book!"); // added semi colon to your code
    }
}

public class GradeBookTest {

    public static void main(String[] args) {

        GradeBook myGradeBook = new GradeBook();

        myGradeBook.displayMessage();
    }
}