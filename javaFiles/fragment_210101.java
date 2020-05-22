<xjc destdir="${basedir}/target/generated-sources/xjc" extension="true">
        <arg line="
            -Xjaxbindex"/>
        <binding dir="${basedir}/src/main/resources">
            <include name="**/*.xjb"/>
        </binding>
        <schema dir="${basedir}/src/main/resources">
            <include name="**/*.xsd"/>
        </schema>
        <!-- Plugins -->
        <classpath>
            <fileset dir="${basedir}/lib">
                <!-- JAXB2 Basics library -->
                <include name="jaxb2-basics-plugins-*.jar"/>
            </fileset>
        </classpath>
    </xjc>