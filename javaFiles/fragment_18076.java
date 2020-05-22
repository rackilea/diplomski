package com.genericsptojson;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;

public class GenericSpToJson {

  private static final String DB_URL = "jdbc:firebirdsql:localhost/3050:/var/lib/firebird/2.5/data/employee.fdb";
  private static final String DB_USER = "SYSDBA";
  private static final String DB_PWD = "***";

  private Connection con;

  public GenericSpToJson(Connection con) {
    this.con = con;
  }

  /**
   * Creates the SQL to call the stored procedure. 
   * 
   * @param spName
   *          Name of stored procecdure to call
   * @param paramCount
   *          number of input parameters
   * @return SQL with placeholders for input parameters
   */
  private String createSql(String spName, int paramCount) {
    if(paramCount > 0) {
      final StringBuilder params = new StringBuilder();
      boolean isFirst = true;
      for(int i = 0; i < paramCount; i++) {
        if(isFirst) {
          isFirst = false;
        } else {
          params.append(", ");
        }
        params.append('?');
      }
      return String.format("SELECT * FROM %s (%s)", spName, params.toString());
    } else {
      return String.format("SELECT * FROM %s", spName);
    }
  }

  /**
   * Creates a PreparedStatement to call the stored procedure. This works only
   * for stored procedures creating result sets. Stored procedures with OUT
   * parameters should be handled by a CallableStatement instead.
   * 
   * @param spName
   *          The stored procedure name to be called.
   * @param params
   *          The input parameters.
   * @return A prepared statement. All parameters are set.
   * @throws SQLException
   */
  private PreparedStatement createStatement(String spName, Object... params) throws SQLException {
    final PreparedStatement stmt = con.prepareStatement(createSql(spName, params.length));
    for(int i = 0; i < params.length; i++) {
      final Object param = params[i];
      if(param instanceof String) {
        stmt.setString(i + 1, (String) param);
      } else if(param instanceof Integer) {
        stmt.setInt(i + 1, ((Integer) param).intValue());
      } else {
        // Handle other param types ...
      }
    }
    return stmt;
  }

  /**
   * Converts the result set to JSON in streaming mode.
   * 
   * @param spName
   *          The stored procedure name.
   * @param rs
   *          The result set of the stored procedure call.
   * @param out
   *          The output stream to write the JSON into.
   * @throws SQLException
   */
  private void convertToJson(String spName, ResultSet rs, OutputStream out) throws SQLException {
    // Get the result set meta data to obtain column information on the fly. 
    final ResultSetMetaData metaData = rs.getMetaData();

    // Create the JSON generator with pretty printing
    final Map<String, Object> properties = new HashMap<String, Object>(1);
    properties.put(JsonGenerator.PRETTY_PRINTING, true);
    final JsonGeneratorFactory jsonGeneratorFactory = Json.createGeneratorFactory(properties);
    final JsonGenerator generator = jsonGeneratorFactory.createGenerator(out);
    generator.writeStartObject(); // root object

    generator.write("storedProcedureName", spName);
    generator.write("columnCount", metaData.getColumnCount());
    generator.writeStartArray("records"); // records array
    while(rs.next()) {
      generator.writeStartObject(); // record object
      // Each record object contains one field for every column.
      // The field name is the columns name.
      for(int col = 1; col <= metaData.getColumnCount(); col++) {
        final String fieldName = metaData.getColumnName(col);
        switch(metaData.getColumnType(col)) {
          case Types.INTEGER:
            final int intValue = rs.getInt(col);
            if(rs.wasNull()) {
              generator.writeNull(fieldName);
            } else {
              generator.write(fieldName, intValue);
            }
            break;
          case Types.VARCHAR:
          case Types.CHAR:
            String stringValue = rs.getString(col);
            if(rs.wasNull()) {
              generator.writeNull(fieldName);
            } else {
              if(metaData.getColumnType(col) == Types.CHAR) {
                stringValue = stringValue.trim();
              }
              generator.write(fieldName, stringValue);
            }
            break;
          // Handle other types here
          default:
            System.out.println(String.format("Unhandled SQL type: %s", metaData.getColumnTypeName(col)));
        }
      }
      generator.writeEnd(); // record object
    }
    generator.writeEnd(); // records array
    generator.writeEnd(); // root object
    generator.flush();
    generator.close();
  }

  /**
   * Executes the stored procedures with the given input parameters and creates
   * JSON in streaming mode.
   * 
   * @param spName
   *          The name of the stored procedure.
   * @param out
   *          The output stream to write the generated JSON into.
   * @param params
   *          The stored procedure's parameters.
   */
  public void executeStoredProcedure(String spName, OutputStream out, Object... params) {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      stmt = createStatement(spName, params);
      rs = stmt.executeQuery();
      convertToJson(spName, rs, out);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // Cleaning up ...
      if(stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(rs != null) {  
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }   
      }
    }
  }

  /**
   * Convenience method to call the stored procedure and create a JSON string.
   * This should only be called for short result sets. For longer result sets
   * use {@link #executeStoredProcedure(String, OutputStream, Object...)} where
   * it is not necessary to hold the entire JSON document in memory.
   * 
   * @param spName
   *          The name of the stored procedure to call.
   * @param params
   *          The stored procedure's parameters
   * @return The stored procedure's call result as a JSON string.
   * @throws UnsupportedEncodingException
   */
  public String executeStoredProcedure(String spName, Object... params) throws UnsupportedEncodingException {
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    executeStoredProcedure(spName, out, params);
    return out.toString("UTF-8");
  }


  public static void main(String[] args) {
    Connection con = null;
    try {
      Class.forName("org.firebirdsql.jdbc.FBDriver");
      con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

      final GenericSpToJson converter = new GenericSpToJson(con);

      System.out.println("Executing stored procedure GET_EMP_PROJ (8):\n"
          + converter.executeStoredProcedure("GET_EMP_PROJ", 8));
      System.out.println("\n\nExecuting stored procedure MAIL_LABEL (1015):\n"
          + converter.executeStoredProcedure("MAIL_LABEL", 1015));
      System.out.println("\n\nExecuting stored procedure ORG_CHART:\n"
          + converter.executeStoredProcedure("ORG_CHART"));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if(con != null) {
      try {
        con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }    
}