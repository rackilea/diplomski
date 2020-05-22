<jar destfile="${dist}/lib/app.jar">
    <fileset dir="${build}/classes"
             excludes="**/Test.class"
    />
    <fileset dir="${src}/resources"/>
</jar>