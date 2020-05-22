<target name="copy-lib" depends="copyseam, copyseamdependencies, copyjbossembedded, copy-icefaces-home, copy-icefaces-maven">
    <echo message="Copying Seam and dependencies to the ${project.home}/lib directory..."/>

    <copy todir="${project.home}/lib" overwrite="true">
        <fileset dir="${seam.dir}/lib">
            <exclude name="jsf-facelets.jar" if="icefaces.property"/>
            <exclude name="ajax4jsf*.jar" if="icefaces.property"/>
            <exclude name="richfaces*.jar" if="icefaces.property"/>
            <exclude name="jboss-container.jar"/>
            <exclude name="jboss-seam-wicket.jar"/>
            <exclude name="jboss-seam-resteasy.jar"/>
            <exclude name="test/jboss-deplyers.jar"/>
            <exclude name="test/jboss-embedded-api.jar"/>
            <exclude name="interop/**/*"/>
            <exclude name="gen/**/*"/>
        </fileset>
        <fileset file="${driver.jar}"/>
    </copy>

    <!-- we must use an endorsed jars directory containing JAXB 2.1 for running SeamTest under Java 6 -->
    <copy todir="${project.home}/lib/endorsed" file="${seam.dir}/lib/gen/jaxb-api.jar" overwrite="true"/>

    <echo message="Copying JBoss Embedded configuration to the ${project.home}/bootstrap directory..."/>
    <copy todir="${project.home}/bootstrap" overwrite="true">
        <fileset dir="${seam.dir}/bootstrap"/>
    </copy>

</target>