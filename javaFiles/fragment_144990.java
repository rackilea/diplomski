//begin a transaction
em.getTransaction().begin();

//remember the old Ingressiconpermesso instance
Ingressiconpermesso oldIngression = persistentInstance.getIngressiconpermesso();

//create a new Ingressiconpermesso instance
Ingressiconpermesso newIngression = new Ingressiconpermesso();
//call newIngression.set...() methods here

//associate the new Ingressiconpermesso with the Permessitemporanei 
persistentInstance.setIngressiconpermesso(newIngression);

//update statopermesso
persistentInstance.setStatopermesso(7); //replace '7' with whatever the real value is

//add a new Accessiconpermesso
Accessiconpermesso accession = new Accessiconpermesso();
//call accession.set...() methods here

//associate the Accessiconpermesso with the Permessitemporanei
accession.setPermissitemporanei(persistentInstance);

//now tell the EntityManager what we did
em.remove(oldIngression);        //delete the old Ingressiconpermesso 
em.persist(newIngression);       //add the new Ingressiconpermesso 
em.persist(accession);           //add the Accessiconpermesso
em.merge(persistentInstance);    //update the Permessitemporanei

//commit the transaction
em.getTransaction().commit();