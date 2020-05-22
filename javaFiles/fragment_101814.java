package com.example.galea.model.types;

import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.ValueExtractor;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicBinder;
import org.hibernate.type.descriptor.sql.BasicExtractor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class TsRangeSqlTypeDescriptor implements SqlTypeDescriptor {

    /**  */
    private static final long serialVersionUID = -4377165492827156136L;

    private static final Log log = LogFactory.getLog(TsRangeSqlTypeDescriptor.class);

    public static final TsRangeSqlTypeDescriptor INSTANCE = new TsRangeSqlTypeDescriptor();

    @Override
    public int getSqlType() {
        return Types.OTHER; // <--- This is importand!
    }

    @Override
    public boolean canBeRemapped() {
        return true;
    }

    @Override
    public <X> ValueBinder<X> getBinder(JavaTypeDescriptor<X> javaTypeDescriptor) {
        return new BasicBinder<X>(javaTypeDescriptor, this) {

            @Override
            protected void doBind(PreparedStatement st, X value, int index, WrapperOptions options) throws SQLException {
                String sqlString = javaTypeDescriptor.toString(value);

                // Here is the solution with Type.OTHER
                st.setObject(index, sqlString, getSqlType());
            }

            @Override
            protected void doBind(CallableStatement st, X value, String name, WrapperOptions options) throws SQLException {
                st.setObject(name, javaTypeDescriptor.toString(value));
            }
        };
    }

    @Override
    public <X> ValueExtractor<X> getExtractor(JavaTypeDescriptor<X> javaTypeDescriptor) {
        return new BasicExtractor<X>(javaTypeDescriptor, this) {

            @Override
            protected X doExtract(ResultSet rs, String name, WrapperOptions options) throws SQLException {
                if(javaTypeDescriptor instanceof TsRangeJavaTypeDescriptor) {
                    TsRangeJavaTypeDescriptor rangeJavaTypeDescriptor = (TsRangeJavaTypeDescriptor) javaTypeDescriptor;

                    Object pgObject = rs.getObject(name);
                    Object valueRaw;
                    // Ugly, but I can not cast PGobject
                    try {
                        valueRaw = pgObject.getClass().getMethod(getValue, null).invoke(pgObject);
                        if(valueRaw instanceof String) {
                            String value = (String) valueRaw;
                            return (X) rangeJavaTypeDescriptor.wrap(value, options);
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                        log.error(Failed to parse pgObject,e);
                    }
                }
                return javaTypeDescriptor.wrap(rs.getObject(name), options);
            }

            @Override
            protected X doExtract(CallableStatement statement, int index, WrapperOptions options) throws SQLException {
                return javaTypeDescriptor.wrap(statement.getObject(index), options);
            }

            @Override
            protected X doExtract(CallableStatement statement, String name, WrapperOptions options) throws SQLException {
                return javaTypeDescriptor.wrap(statement.getObject(name), options);
            }
        };
    }

}