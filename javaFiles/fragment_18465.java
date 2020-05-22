<library id="OracleLib">
    <fileset dir="${server.config.dir}/oracle"/>
</library>

<application location="myApp.war" >
    <classloader commonLibraryRef="OracleLib"/>
</application>

<dataSource jndiName="jdbc/oracleDataSource">
    <jdbcDriver libraryRef="OracleLib"/>
    <properties.oracle .../>
</dataSource>