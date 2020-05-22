<resources>
    <resource>
        <directory>${basedir}/src/main/resources</directory>
        <filtering>true</filtering>
        <includes>
            <!-- whatever is defined here will have filters applied -->
            <include>**/UI.gwt.xml</include>
        </includes>
    </resource>
    <resource>
        <directory>${basedir}/src/main/resources</directory>
        <filtering>false</filtering>
        <!-- everything in this directory remains the same (no filters) -->
        <excludes>
            <!-- the excludes found here will be altered by the filters in the first resource set -->
            <!-- so we need to define them as excluded from the files that should not have filters applied -->
            <exclude>**/UI.gwt.xml</exclude>
        </excludes>
    </resource>
</resources>