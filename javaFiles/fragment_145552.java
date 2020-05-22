import org.hibernate.usertype.UserType;

public InetType impelements UserType{

public Class<String> returnedClass() {
    return String.class;
}

public int[] sqlTypes() {
    return new int[] { Types.OTHER }; // as the db type is inet and not directly transmutable to hibernate type.
}

public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner)
        throws HibernateException, SQLException {
    String value = (String) Hibernate.STRING.nullSafeGet(resultSet, names[0]);
    return value;        
}

public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index)
        throws HibernateException, SQLException {
    Hibernate.STRING.nullSafeSet(preparedStatement, 
            (value != null) ? value.toString() : null, index);
}
}