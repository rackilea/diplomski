public void updateStudent(){ 

        Transaction transaction = session.beginTransaction();           
        Student s = (Student)session.get(Student.class, new Long(1));   
        Set<Phone> phoneNumbers =s.getStudentPhoneNumbers();   
        Phone phone = new Phone("house", "12342342");
        phone.setStudent(s);
        phoneNumbers.add(phone);   
        s.setStudentPhoneNumbers(phoneNumbers);   
        session.update(s);   
        transaction.commit(); 

    }