import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class CustAddressType implements UserType {
    private static final int SQL_TYPE = Types.STRUCT;
    private static final String OBJECT_TYPE = "CUST_ADDRESS_TYP";
    /**
     * Returns the object from the 2 level cache
     */
    public Object assemble(Serializable cached, Object owner)
        throws HibernateException {
    return cached;
}

/**
 * Used to create Snapshots of the object
 */
public Object deepCopy(Object value) throws HibernateException {
    if (value == null) {
        return null;
    }
    final Cust_addressData recievedParam = (Cust_addressData) value;
    final Cust_addressData addressData = new Cust_addressData(recievedParam);

    return addressData;
}

/**
 * method called when Hibernate puts the data in a second level cache. The
 * data is stored in a serializable form
 */
public Serializable disassemble(final Object value)
        throws HibernateException {
    return (Serializable) value;
}

public boolean equals(final Object o1, final Object o2)
        throws HibernateException {
    boolean isEqual = false;
    if (o1 == o2) {
        isEqual = true;
    }
    if (null == o1 || null == o2) {
        isEqual = false;
    } else {
        isEqual = o1.equals(o2);
    }
    return isEqual;
    // for this to work correctly the equals()
    // method must be implemented correctly by Cust_addressData class
}

public int hashCode(final Object arg0) throws HibernateException {
    return arg0.hashCode();
}

public boolean isMutable() {
    return true;
}

public Object nullSafeGet(final ResultSet resultSet, final String[] names,
        SessionImplementor sessionImp, final Object owner)
        throws HibernateException, SQLException {

    // owner here is class from where the call to retrieve data was made.
    // In this case the Test class

    final Cust_addressData addresssData = new Cust_addressData();

    final Struct struct = (Struct) resultSet.getObject(names[0]);

    if (resultSet.wasNull()) {
        return null;
    }
    addresssData.setCity((String)struct.getAttributes()[0]);
    addresssData.setCountry_id((String)struct.getAttributes()[1]);
    addresssData.setPostal_code((String)struct.getAttributes()[2]);
    addresssData.setState_province((String)struct.getAttributes()[3]);
    addresssData.setStreet_address((String)struct.getAttributes()[4]);

    return addresssData;
}

public void nullSafeSet(final PreparedStatement statement, final Object value, final int index,
        SessionImplementor arg3) throws HibernateException, SQLException {
    if (value == null) {
        statement.setNull(index, SQL_TYPE, OBJECT_TYPE);
    } 
    else {
        final Cust_addressData addresssData = (Cust_addressData) value;
        final Object[] values = new Object[] { addresssData.getCity(),addresssData.getCountry_id(), addresssData.getPostal_code(),
                addresssData.getState_province(),addresssData.getStreet_address() };
        final Connection connection = statement.getConnection();
        final STRUCT struct = new STRUCT(StructDescriptor.createDescriptor( OBJECT_TYPE,connection), connection, values);
        statement.setObject(index, struct, SQL_TYPE);
    }
}

public Object replace(final Object original, final Object target,
        final Object owner) throws HibernateException {
    return this.deepCopy(original);
}

@SuppressWarnings("rawtypes")
public Class returnedClass() {
    return Cust_addressData.class;
}

public int[] sqlTypes() {
    return new int[] {SQL_TYPE};
}
}