public class UUIDType extends AbstractSingleColumnStandardBasicType<UUID> {
public static final String NAME = "uuid-name";
public static final UUIDType INSTANCE = new UUIDType();

public UUIDType() {
    super( UUIDSqlTypeDescriptor.INSTANCE, UUIDTypeDescriptor.INSTANCE );
}

public String getName() {
    return NAME;
}

public static class UUIDSqlTypeDescriptor implements SqlTypeDescriptor {
    public static final UUIDSqlTypeDescriptor INSTANCE = new UUIDSqlTypeDescriptor();

    public int getSqlType() {
        // ugh
        return Types.VARCHAR;
    }

    @Override
    public boolean canBeRemapped() {
        return true;
    }

    public <X> ValueBinder<X> getBinder( final JavaTypeDescriptor<X> javaTypeDescriptor ) {
        return new BasicBinder<X>( javaTypeDescriptor, this ) {
            @Override
            protected void doBind( PreparedStatement st, X value, int index, WrapperOptions options )
                    throws SQLException {
                st.setObject( index, javaTypeDescriptor.unwrap( value, UUID.class, options ) );
            }
        };
    }

    public <X> ValueExtractor<X> getExtractor( final JavaTypeDescriptor<X> javaTypeDescriptor ) {
        return new BasicExtractor<X>( javaTypeDescriptor, this ) {
            @Override
            protected X doExtract( ResultSet rs, String name, WrapperOptions options ) throws SQLException {
                return javaTypeDescriptor.wrap( rs.getObject( name ), options );
            }

            @Override
            protected X doExtract( CallableStatement statement, int index, WrapperOptions options )
                    throws SQLException {
                return javaTypeDescriptor.wrap( statement.getObject( index ), options );
            }

            @Override
            protected X doExtract( CallableStatement statement, String name, WrapperOptions options )
                    throws SQLException {
                return javaTypeDescriptor.wrap( statement.getObject( name ), options );
            }
        };
    }
}
}