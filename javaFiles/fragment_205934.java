<target name = "build" depends = "JFXSign">
    <jar destfile = "${store.dir}/temp_final.jar"
  filesetmanifest = "skip">
        <zipgroupfileset dir = "${JFX.build.dir}"
                     includes = "*.jar"/>
        <zipgroupfileset dir = "${JFX.lib.dir}"
                    includes = "*.jar"/>
        <manifest>
            <attribute name = "Main-Class"
                      value = "${JFXMainClass}"/>
        </manifest>
    </jar>
</target>

<target name = "store" depends = "build">
    <zip destfile = "${store.dir}/${JFXProject.name}.jar">
        <zipfileset src = "${store.dir}/temp_final.jar"
               excludes = "META-INF/*sf, META-INF/*.DSA, META-INF/*RSA"/>
    </zip>
    <delete file = "${store.dir}/temp_final.jar"/>
</target>

<target name = "BuildStoreAndSign" depends = "store">
    <signjar
         keystore = "${comodo.key.store}"
            alias = "${comodo.key.alias}"
        storetype = "PKCS12" <!-- This is necessary for me, but may not be for you if you are not using a PFX file -->
           tsaurl = "${timestamp.url}"
          keypass = "${comodo.key.pass}"
        storepass = "${comodo.key.storepass}"
              jar = "${store.dir}/${JFXProject.name}.jar"
          destdir = "${sign.dir}"/>
    <delete dir = "${JFX.compile.dir}"/>
    <delete dir = "${JFX.build.dir}"/>
    <delete dir = "${JFX.sign.dir}"/>
    <delete dir = "${store.dir}"/>
</target>