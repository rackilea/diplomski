@Override
public void nullSafeSet(PreparedStatement st, Object value, int index,
        final SharedSessionContractImplementor session) throws HibernateException, SQLException {

    // Simply do what 
    // org.hibernate.type.AbstractStandardBasicType.nullSafeSet(PreparedStatement, Object, int, WrapperOptions)
    // does, but using a custom descriptor.

    session.remapSqlTypeDescriptor(MaterializedBlobType.INSTANCE.getSqlTypeDescriptor())
            .getBinder(CustomPrimitiveByteArrayTypeDescriptor.INSTANCE)
            .bind(st, (byte[]) value, index, session);
}