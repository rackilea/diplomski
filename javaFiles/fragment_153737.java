...
First first = new First();
entityManager.save(first);  //<- the id is updated

Second second = new Second();
second.setB(300);     
second.setA(first.getA()); 

first.setSeconds( new ArrayList());
first.getSeconds().add(second);
entityManager.save(second);

entityManager.getTransaction().commit();