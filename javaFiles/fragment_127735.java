em = factory.createEntityManager();
em.getTransaction().begin();
int i = 0;

   for (Object ob : list) {
       Long start = Calendar.getInstance().getTimeInMillis();

       em.merge(ob);

       Long end = Calendar.getInstance().getTimeInMillis();
       Long diff = end - start;
       LOGGER.info("Time: " + diff);

       /*BATCH_SIZE is the number of entities 
            that will be persisted/merged at once */

       if(i%BATCH_SIZE == 0){    
           em.flush();
           em.clear(); 
       }

       i++;
   }

em.getTransaction().commit();
em.close();