<for param="filename">
    <path id="project.fileset">
        <fileset dir="${basedir}/js" includes="/*">
            <include name="**/*.js" />
        </fileset>
    </path>
    <sequential>
        <basename property="file.@{filename}" file="@{filename}"/>
        <!-- dirname strips off the trailing file name, leaving the full dir -->
        <dirname property="dir.@{filename}" file="@{filename}"/>
        <pathconvert property="currentdirectory.@{filename}">
            <file file="${dir.@{filename}}" />
            <!-- pathconvert strips off the leading ${basedir}/js -->
            <map from="${basedir}/js" to="" />
        </pathconvert>
        <echo message="FullPath:@{filename}" />
        <echo message="Directory:${currentdirectory.@{filename}}" />
    </sequential>
</for>