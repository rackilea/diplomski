<Configuration status="trace" packages="my.rewritepolicy.plugin.package">
  <Appenders>
    <Console name="STDOUT">
      <PatternLayout pattern="[%-5level] %c{1.} %m%n"/>
    </Console>
    <Rewrite name="Rewrite">
      <InjectMarkerPolicy />
      <AppenderRef ref="STDOUT"/>
    </Rewrite>
  </Appenders>
  <Loggers>
    <Root level="trace">
      <AppenderRef ref="Rewrite"/>
    </Root>
  </Loggers>
</Configuration>