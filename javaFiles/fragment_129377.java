display.setFont(new Font("serif",Font.BOLD,14));

int maxLength = Integer.MAX_VALUE;
for (Student student : listof) {
    maxLength = Math.min(maxLength, (student.getSname().length()+getLname().length()));
}
display.setText(Student.getAlignedHeader(maxLength));
//append student as you already do