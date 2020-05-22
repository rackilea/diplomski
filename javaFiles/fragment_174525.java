Query query=getEntityManager().
                           createNativeQuery("BEGIN SPGetChart(:id, :name); END;");
   query.setParameter("id", idValue);
   query.setParameter("name", nameChart);

   query.executeUpdate();