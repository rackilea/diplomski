public void updateStudent(){ 

        Transaction transaction = session.beginTransaction();           
        Student s = (Student)session.get(Student.class, new Long(1));   
        Phone phone = new Phone("house", "12342342");
        s.addPhone(phone);
        session.update(s);   
        transaction.commit(); 

    }