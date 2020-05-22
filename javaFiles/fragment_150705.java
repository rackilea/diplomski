if (convertedInputScore == -1) {
    System.exit(0);
} else if (convertedInputScore < 39) {
    JOptionPane.showMessageDialog(Program1.this, "The student received a fail grade", "Student mark checker", JOptionPane.INFORMATION_MESSAGE);            
} else if (convertedInputScore <= 49) {
    JOptionPane.showMessageDialog(Program1.this, "The student received an E grade", "Student mark checker", JOptionPane.INFORMATION_MESSAGE);
} else if (convertedInputScore <= 59) {
    JOptionPane.showMessageDialog(Program1.this, "The student received an D grade", "Student mark checker", JOptionPane.INFORMATION_MESSAGE);
}