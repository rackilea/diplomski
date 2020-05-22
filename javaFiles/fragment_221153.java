Student student;

if (studentType == 1) {
    student = new UnderGrad();
} else {
    student = new Grad();
}

student.setNumAssignments();