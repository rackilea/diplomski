public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
    if (value == null) {
        st.setNull(index, Types.VARCHAR);
    }
    else {
//            previously used setString, but this causes postgresql to bark about incompatible types.
//           now using setObject passing in the java type for the postgres enum object
//            st.setString(index,((Enum) value).name());
        st.setObject(index,((Enum) value), Types.OTHER);
    }
}