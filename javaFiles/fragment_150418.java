Session miasession = HibernateUtil.getSessionFactory().getCurrentSession();

Invoice i = (Invoice) miasession.get(Invoice.class, id); 

// load the collection before session is closed
model.addAttribute("subject", Hibernate.initialize(i.getSubject()));