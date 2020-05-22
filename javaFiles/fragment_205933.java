<target name = "JFXSign" depends = "JFXBuild">
    <fx:signjar  keystore = "${comodo.key.store}"
                    alias = "${comodo.key.alias}"
                storetype = "PKCS12" <!-- This is necessary for me, but may not be for you if you are not using a PFX file -->
                  keypass = "${comodo.key.pass}"
                storepass = "${comodo.key.storepass}"
                      jar = "${JFX.build.dir}/${JFXProject.name}.jar"
                  destdir = "${JFX.sign.dir}"/>
</target>