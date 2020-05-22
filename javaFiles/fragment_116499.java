numOfStudents++; // only increase the count right before the loop, after you've added the new student to the arrays. 

StringBuilder sb = new StringBuilder();

for (int x=0; x < numOfStudents ; x++) {
    sb.append(studentNames[x]);
    for (int y=0; y < 4; y++) {
        sb.append(" " + aryStudent[x][y]);
    }     
    sb.append("\n");   
} 
studentListField.setText(sb.toString());