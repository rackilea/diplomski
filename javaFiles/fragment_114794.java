public void save(){
   //begin transaction
   getEntityManager.persist(newProperty);
   // end transaction...
   newPropertyAttriubtes.forEach(attr -> {
          //begin transaction...
          getEntityManager.merge(attr);
          // end transaction
          newProperty.attach(attr)
   }
   //begin transaction
   // to have the PropertyAttributes attached in the EntityManager => merge
   getEntityManager.merge(newProperty); 
   // end transaction...
   }
}