Connection con = ((SessionImpl) getEntityManager().getDelegate()).connection();
   CallableStatement callableStatement = cc.prepareCall("{call SPGetChart (?,?)}");

   callableStatement.setInt(1, idValue);
   callableStatement.setString(2, nameChart);
   callableStatement.execute();