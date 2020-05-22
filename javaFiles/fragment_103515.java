<fileset dir="${eclipse.pdebuild.home}" id="plugins.jars"
  includes="com.ibm.icu*.jar,org.eclipse.equinox.simpleconfigurator*.jar/>

<!-- simple echo -->
<echo>${toString:plugins.jars}</echo>

<pathconvert pathsep=";" property="plugins" refid="plugins.jars"/>