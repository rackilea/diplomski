public class NStringUserType implements UserType  {

    @Override
    public Object assemble(Serializable arg0, Object owner)
            throws HibernateException {

        return deepCopy(arg0);
    }

    @Override
    public Object deepCopy(Object arg0) throws HibernateException {
        if(arg0==null) return null;
        return arg0.toString();
    }

    @Override
    public Serializable disassemble(Object arg0) throws HibernateException {
        return (Serializable)deepCopy(arg0);
    }

    @Override
    public boolean equals(Object arg0, Object arg1) throws HibernateException {
        if(arg0 == null )
            return arg1 == null;
        return arg0.equals(arg1);
    }

    @Override
    public int hashCode(Object arg0) throws HibernateException {
        return arg0.hashCode();
    }

    @Override
    public boolean isMutable() {
        return false;
    }


    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index)
            throws HibernateException, SQLException {
        if(value == null)
            st.setNull(index,Types.NVARCHAR);
        else
            st.setNString(index, value.toString());
    }

    @Override
    public Object replace(Object arg0, Object target, Object owner)
            throws HibernateException {
        return deepCopy(arg0);
    }

    @Override
    public Class returnedClass() {
        return String.class;
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.NVARCHAR};
    }


    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner)
            throws HibernateException, SQLException {
        String result = resultSet.getString(names[0]);
        return result == null || result.trim().length() == 0 
            ? null : result;
    }

}