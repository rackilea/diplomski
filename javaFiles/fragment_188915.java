static int createPerson(int c){
        return (++c);
    }

     static int create2Persons(int c) {

    return Student.createPerson(Student.createPerson(c));
    }

    static int create3Persons(int c) {

        return Student.createPerson(Student.createPerson(Student.createPerson(c)));


    }




        public static int create5Persons(int i) {
   return Student.createPerson(Student.createPerson(Student.createPerson(Student.createPerson(Student.createPerson(i)))));
        }