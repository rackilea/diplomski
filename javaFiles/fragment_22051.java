String query = "SELECT email, id FROM Login WHERE email=? AND password=?";
 Object[] parameters = { login.getEmail(), login.getPassword() };
 List results = getHibernateTemplate().find(query, parameters);
 if (results.size() != 1) {
     // Probably throw an exception
 }
 // I'm assuming your mapping has been set up appropriately such that
 // the returned value will *be* an `ILogin`.
 return (ILogin) results.get(0);