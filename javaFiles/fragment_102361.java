<build>
    <finalName>${project.artifactId}</finalName>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
        </resource>
        <resource>
            <directory>src/main/config</directory>
        </resource>
         <resource>
            <directory>src/main/resources</directory>
        </resource>
    </resources>
    <testResources>
        <testResource>
            <directory>src/main/config</directory>
        </testResource>
         <testResource>
            <directory>src/main/resources</directory>
        </testResource>
    </testResources>

    <!-- Other pom.xml stuff -->

</build>