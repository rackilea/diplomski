public ArrayList<Student> filterClasses (String classe){
        ArrayList<Student> fullresult = new ArrayList<Student>();
        for (Student student : studentDB ) {
                if (student.classes().contains(classe)){
                    fullresult.add(student);
                }
            }
        }
        System.out.println(fullresult);
        return fullresult;
    }