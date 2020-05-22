// This stored procedure returns a result set and has one input parameter.
@NamedStoredProcedureQuery(
    name = "ReadAddressById",
    resultClasses = Address.class,
    procedureName = "READ_ADDRESS",
    parameters = {
        @StoredProcedureParameter(mode=javax.persistence.ParameterMode.IN, name="P_ADDRESS_ID", type=Long.class)
    }
)
@Entity
public class Address {
  ...
}