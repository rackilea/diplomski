for (String studentName : courseListsByStudentName.keySet()) {
     int units = 0;
     List<Course> courses = courseListsByStudentName.get(studentName);
     for (Course course : courses) {
         units += course.getNumUnits();
     }
     if (units > unitThreshold) {
         overEnrolledStudents.add(studentName);
     }
 }