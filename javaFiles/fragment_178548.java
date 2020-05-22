entityManager.getTransaction().begin();
User user = getUserFromDB();
Invoice invoice = // get the invoice or use an invoice received as method param
user.setInvoice(invoice);
invoice.setUser(user);
entityManager.persist(invoice);
entityManager.getTransaction().commit();