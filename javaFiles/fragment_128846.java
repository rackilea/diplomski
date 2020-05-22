# Database configuration
# ~~~~~ 
# You can declare as many datasources as you want.
# By convention, the default datasource is named `default`
#
# db.default.driver=org.h2.Driver
# db.default.url="jdbc:h2:mem:play"
# db.default.user=sa
# db.default.password=

db.default.driver=com.mysql.jdbc.Driver
db.default.url="jdbc:"${DATABASE_URL_DB}
db.default.user=${DATABASE_USERNAME_DB}
db.default.password=${DATABASE_PASSWORD_DB}
db.default.maxConnectionsPerPartition=10
db.default.partitionCount=2