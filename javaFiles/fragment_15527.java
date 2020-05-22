while (rs.next()) {
        tempStudent = new Students();
        tempStudent.studentId = rs.getInt("StudentNo");
        tempStudent.studentName = rs.getString("StudentName");
        tempStudent.studentAge = rs.getInt("StudentAge");
        students.add(tempStudent);
        size++;
    }