import oracle.jdbc.driver.*;

public class TestBlob {
  public static oracle.sql.BLOB getBlob(String username) throws Exception {
    oracle.jdbc.OracleConnection conn = 
      (oracle.jdbc.OracleConnection)new OracleDriver().defaultConnection();

    oracle.sql.BLOB retBlob =
      oracle.sql.BLOB.createTemporary(conn,
                                      true,
                                      oracle.sql.BLOB.DURATION_SESSION);

    java.io.OutputStream outStr = retBlob.setBinaryStream(0);
    outStr.write(username.getBytes());
    outStr.flush();

    return retBlob;
  }
}