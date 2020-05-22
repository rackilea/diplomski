public class DefaultLongType implements UserType {
private static final long serialVersionUID = 1L;

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable, java.lang.Object)
 */
public Object assemble(Serializable cached, Object owner)
        throws HibernateException {
    return null;
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
 */
public Object deepCopy(Object value) throws HibernateException {
    return null;
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
 */
public Serializable disassemble(Object value) throws HibernateException {
    return null;
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
 */
public boolean equals(Object x, Object y) throws HibernateException {
    if (x == y) return true;
    if (x == null) return false;
    return x.equals(y);
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
 */
public int hashCode(Object x) throws HibernateException {
    return x == null ? 0 : x.hashCode();
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#isMutable()
 */
public boolean isMutable() {
    return false;
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], java.lang.Object)
 */
public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
        throws HibernateException, SQLException {
    final long value = rs.getLong(names[0]);
    if (rs.wasNull()) {
        return new Long(Long.MIN_VALUE);
    }
    return new Long(value);
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int)
 */
public void nullSafeSet(PreparedStatement st, Object value, int index)
        throws HibernateException, SQLException {
    Long l = (Long) value;
    if (l == null || l.longValue() == Long.MIN_VALUE) {
        st.setNull(index, Types.NUMERIC);
    }
    else {
        st.setLong(index, l.longValue());
    }
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#replace(java.lang.Object, java.lang.Object, java.lang.Object)
 */
public Object replace(Object original, Object target, Object owner)
        throws HibernateException {
    return original;
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#returnedClass()
 */
public Class returnedClass() {
    return Long.class;
}

/* (non-Javadoc)
 * @see org.hibernate.usertype.UserType#sqlTypes()
 */
public int[] sqlTypes() {
    final int[] args = { Types.NUMERIC };
    return args;
}