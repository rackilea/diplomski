<cobertura-instrument todir="${instrumented.dir}">
    <ignore regex="java.util.logging.*" />
    <fileset dir="${classes.dir}">
        ...
    </fileset>
</cobertura-instrument>