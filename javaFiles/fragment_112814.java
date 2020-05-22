EntityManager em = emf.createEntityManager();

        Message message0 = new Message();
        message0.setText("Hi!!");
        em.getTransaction().begin();
        em.persist(message0);
        em.getTransaction().commit();

        // no close here

        Message message1 = new Message();
        message1.setText("Bye!!");

        System.out.println("i'm here");
        em.getTransaction().begin();
        em.persist(message1);
        em.getTransaction().commit();

em.close();