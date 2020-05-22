public Object getResult(ResultGetter getter) throws SQLException {
   Timestamp date = getter.getTimestamp();
   if(date == null) return null; 
   LocalDateTime ldt = null;
   try {
      ldt = LocalDateTime.fromDateFields(date);
   } catch(IllegalArgumentException e) {
      throw new SQLException("illegal value for a LocalDateTime : " + date);
   }
   return ldt; 
}

public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
   java.sql.Timestamp date = null; 
   if(parameter != null) { 
      LocalDateTime ldt = (LocalDateTime) parameter;
      date = new Timestamp(ldt.toDateTime().getMillis());
   } 
   setter.setTimestamp(date);
}