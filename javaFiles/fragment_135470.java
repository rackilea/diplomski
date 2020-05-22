<delete includeEmptyDirs="false">
    <fileset dir="${basedir}/target/${project.build.finalName}/resources/js" excludes="**/*-min.js" />          
</delete>
<move todir="${basedir}/target/${project.build.finalName}/resources/js" includeemptydirs="false">
    <fileset dir="${basedir}/target/${project.build.finalName}/resources/js" />
    <mapper type="glob" from="*-min.js" to="*.js" />
</move>

<delete includeEmptyDirs="false">
<fileset dir="${basedir}/target/${project.build.finalName}/resources/css"
    excludes="**/*-min.css, **/*.ttf, **/*.png, **/*.jpg" />
</delete>
<move todir="${basedir}/target/${project.build.finalName}/resources/css" includeemptydirs="false">
    <fileset dir="${basedir}/target/${project.build.finalName}/resources/css" />
    <mapper type="glob" from="*-min.css" to="*.css" />
</move>