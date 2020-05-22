abstract class Database {
  enum Type { ORACLE, POSTGRES }

  String url
  String username
  String password
  abstract def getJdbc()
  abstract def getDriver()  

  static Database create(Database.Type type, Map params) {
    def db = [
      (Type.ORACLE)   : OracleDatabase, 
      (Type.POSTGRES) : PostgresDatabase
    ][type].newInstance() 

    assert (db.username = params.username), "No username given"
    assert (db.password = params.password), "No password given"
    assert (db.url = params.url), "No database URL given" 

    return db
  }

  Map<String, List> execute(sqlStatements) {
    try {
      Map<String, List> resultSets = [:]

      assert sqlStatements != null 

      def sql = groovy.sql.Sql.newInstance(url, username, password, driver)

      sqlStatements.each { queryAlias, query ->

        def columns=[]
        sql.eachRow(query) { row ->
          if (columns.isEmpty()) {
            int colCount = row.columnCount
            columns = (1..colCount).collect { row.getColumnName it }
          }

          resultSets[queryAlias] = columns.collect { column -> row.getColumn(column) }
        }
      }
      return resultSet
    }
    catch(se) {
      println "Exception encountered in DBUtil execute() $se"
      throw se
    }
  }

}

class OracleDatabase extends Database {
  def getJdbc() { "jdbc:agra:oracle" }
  def getDriver() { "com.agra.jdbc.oracle.OracleDriver" }
}

class PostgresDatabase extends Database {
  def getJdbc() { "jdbc:agra:mysql" }
  def getDriver() { "org.postgresql.Driver" }
}


def dbparams = [
  "username":"johnkc", 
  "password":"johnc", 
  "url":"apple:1521;SID=ORCL;"
]

def sqlStatements = [
  "sql1":"select name, value from v\$parameter",
  "sql2":"select POO_NAME, POO_VALUE from PO_OPTION"
]

def db = Database.create(Database.Type.ORACLE, dbparams)

def result = db.execute(sqlStatements)
assert result instanceof Map
assert result.keySet().size() == 2
assert result.each { key, value -> value instanceof List }