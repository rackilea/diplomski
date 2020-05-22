session = sessionGet.openSession();
        **Transaction tx= session.beginTransaction();**
        Contact contact = new Contact();

         contact.setFirstName("xyz");
         contact.setLastName("zyx");
         contact.setEmail("x@xmail.com");
         contact.setId(20);
         session.save(contact);
         **tx.commit();**