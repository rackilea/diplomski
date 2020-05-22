<RollingFile name="RollingFile" fileName="logs/app.log"
             filePattern="logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}.log.gz">

  <!-- use custom lookups to access arbitrary internal system info -->
  <PatternLayout header="${setu:key1} ${setu:key2}">
    <Pattern>%d %m%n</Pattern>
  </PatternLayout>
  <Policies>
    <TimeBasedTriggeringPolicy />
  </Policies>
</RollingFile>