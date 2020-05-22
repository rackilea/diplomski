@Override
public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
    if (value == null) {
        st.setNull(index, Types.VARCHAR);
    }
    else {
        st.setObject(index, ((Enum) value).name(), Types.OTHER);
    }
}