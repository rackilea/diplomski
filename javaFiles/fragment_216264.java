String s0 = JOptionPane.showInputDialog( "no. of Students" );
Integer number_of_students = 0;
try {
    number_of_students = Integer.parseInt(s0);


    String output = "Name of the Student\tExam Marks\n";
    for ( int counter = 1; counter <= number_of_students; counter++ ){

        String s1 = JOptionPane.showInputDialog( "Enter the Name of Student - " + counter );

        String s2 = JOptionPane.showInputDialog("Enter the Exam Marks for " + s1 );

        output += counter + "\t" + s1 + "\t" + s2 + "\n";
    }

    JTextArea outputArea = new JTextArea();

    outputArea.setText( output);

    JOptionPane.showMessageDialog( null, outputArea,
            "Analysis of Exam Marks",
            JOptionPane.INFORMATION_MESSAGE );

} catch (Exception e) {
    JOptionPane.showMessageDialog( null, "Please , enter numeric values only",
            "Analysis of Exam Marks",
            JOptionPane.INFORMATION_MESSAGE );
}