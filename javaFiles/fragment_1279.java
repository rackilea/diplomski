for (int i = 0; i < arrStudent.size(); i++) {
        Student student = arrStudent.get(i);
        if (arrStr.contains(student.getID())) {
            arrStudent.remove(i);
            i--;
        } else {
            System.out.println("Else Called");
        }
    }