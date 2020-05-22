numberOfStudents=Integer.parseInt(
    JOptionPane.showInputDialog("Enter the number of students in the class: "));

int tablets = 1;
if(numberOfStudents > 40) {
    tablets += 1 + (numberOfStudents - 41) / 30;
}

System.out.println("There are a total of " + numberOfStudents + " students in this class");
System.out.println("You will need " + tablets + " tablet for the e-register");