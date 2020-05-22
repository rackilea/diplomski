<Configuration status="trace" packages="com.mycompany.myproduct">
...
<Appenders>
<RollingFile name="RollingFile" fileName="logs/app.log"
             filePattern="logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}.log.gz">

  <!-- use custom lookups to access arbitrary internal system info -->
  <PatternLayout header="${FabLookup:key1} ${FabLookup:key2}">
    <Pattern>%d %m%n</Pattern>
  </PatternLayout>
  <Policies>
    <TimeBasedTriggeringPolicy />
  </Policies>
</RollingFile>
...