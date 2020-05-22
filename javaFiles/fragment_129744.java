#
# SubSection 1.0 # JDBCProvider attributes
#
ResourceType=JDBCProvider
ImplementingResourceType=JDBCProvider
ResourceId=Cell=myCell:JDBCProvider=ID#builtin_jdbcprovider
#

#
#Properties
#
classpath={${DERBY_JDBC_DRIVER_PATH}/derby.jar,/my.jar}
implementationClassName=org.apache.derby.jdbc.EmbeddedXADataSource
name=Derby JDBC Provider (XA)
nativepath={}
description=Built-in Derby JDBC Provider (XA)
providerType=Derby JDBC Provider (XA)
xa=true #boolean