@Override
public Class<?> returnedClass() {
    return PhoneNumber.class;
}

@Override
public int[] sqlTypes() {
    return new int[] { Types.VARCHAR };
}

@Override
public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
    final String value = rs.getString(names[0]);
    return /* PhoneNumber instance created from string. */
}

@Override
public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
    if (value == null) {
        st.setNull(index, Types.VARBINARY);
        return;
    }

    st.setString(index, ((PhoneNumber) value).toString());
}