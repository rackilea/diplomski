public static <T> T unproxy(T entity){
   Hibernate.initialize(entity)
   if(entity instanceof HibernateProxy){
       entity = (T)((HibernateProxy)entity).getHibernateLazyInitializer().getImplementation();
   } else {
       entity = (T)entity
   }
   return entity;
}