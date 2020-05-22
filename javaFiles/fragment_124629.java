<build>
    <outputDirectory>${basedir}/src/main/webapp/WEB-INF/classes</outputDirectory>
    <filters>
      <filter>src/main/filters/filter-${env}.properties</filter> <!-- ${env} default to "development" -->
    </filters>
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.xml</include>
          <include>**/*.properties</include>
        </includes>
        <filtering>true</filtering>
      </resource>
    </resources>
  </build>