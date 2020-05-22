:: schemacrawler batch launcher
@echo off
C:\JDK\bin\java.exe -classpath jtds-1.2.4.jar;schemacrawler-8.8.jar; \
schemacrawler-sqlserver-8.8.jar schemacrawler.tools.sqlserver.Main \
-user=sa -password=password -database=openfire -schemas=openfire.dbo.* \
-port=1433 -host=localhost -table_types=TABLE -command=schema \
-infolevel=standard -loglevel=FINE