public class LowerCaseString implements UserType
 {  
     //....  
        public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index)
            throws HibernateException, SQLException {
        Hibernate.STRING.nullSafeSet(preparedStatement, 
                (value != null) ? ((String)value).toLowerCase() : null, index);
         }  
    ///....  
}