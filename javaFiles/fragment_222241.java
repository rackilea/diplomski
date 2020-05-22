@Override
public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
    // Access column in order defined in getPropertyNames()
    final String number = rs.getString(names[0]);
    final String code = rs.getString(names[1]);
    return /* PhoneNumber instance created from number and country code. */
}