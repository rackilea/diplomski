<target name="sat-beans">
    <mkdir  dir="${xbean-gen}"/>
    <mkdir  dir="${xbean-classes}"/>
    <taskdef name="xmlbean" classname="${xbean-class-name}" classpath="${xbean-class-path}"/>
    <xmlbean schema="./xsd/CfeTeste_0006.xsd" classgendir="${xbean-classes}" 
            srcgendir="${xbean-gen}"  
            destfile="${xbean-dest-file}" 
            classpath="${xbean-class-path}" />
</target>