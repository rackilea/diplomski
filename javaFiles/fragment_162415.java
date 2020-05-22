public Student remove(String removeName) {
        for (Student stu : studentList) {
            if (stu.getName().toUpperCase().contains(removeName.toUpperCase())) {
                System.out.println("Found and Removed");
                studentList.remove(stu);
                return stu;
            }
         }
         System.out.println("Not Found");
         return null;
    }