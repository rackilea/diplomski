from __future__ import with_statement

from com.ziclix.python.sql import PyConnection
import org.apache.tomcat.jdbc.pool as pool

# https://people.apache.org/~fhanik/jdbc-pool/jdbc-pool.html
p = pool.PoolProperties()
p.setUrl('jdbc:mysql://localhost:3306/my_database')
p.setDriverClassName('com.mysql.jdbc.Driver')
p.setUsername('mario')
p.setPassword('myP@ssw0rd')
p.setValidationQuery("SELECT 1")
p.setJdbcInterceptors('org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;' + 
                      'org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer')

datasource = pool.DataSource()
datasource.setPoolProperties(p)

# http://www.jython.org/javadoc/com/ziclix/python/sql/PyConnection.html
conn = PyConnection(datasource.getConnection())

with conn.cursor() as cursor:
    cursor.execute('SELECT * FROM MyTable')
    data = cursor.fetchall()
    print data

conn.close()