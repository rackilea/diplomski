ResultSet java.sql.DatabaseMetaData.getClientInfoProperties() throws SQLException

Retrieves a list of the client info properties that the driver supports. The result set contains the following columns 

1. NAME String=> The name of the client info property
2. MAX_LEN int=> The maximum length of the value for the property
3. DEFAULT_VALUE String=> The default value of the property
4. DESCRIPTION String=> A description of the property. This will typically contain information as to where this property is stored in the database. 

The ResultSet is sorted by the NAME column 

Returns:

A ResultSet object; each row is a supported client info property