./eclipse\
      -nosplash -consolelog -debug\
      -vm "${VM}"\
      -application org.eclipse.equinox.p2.director.app.application\
      -metadataRepository file:${SHARED_REPOSITORY_DIR}\
      -artifactRepository file:${SHARED_REPOSITORY_DIR}\
      -installIU "${4-org.eclipse.sdk.ide}"\
      -destination "${3}"\
      -profile "${1}"\
      -profileProperties org.eclipse.update.install.features=true\
      -bundlepool ${SHARED_BUNDLEPOOL_DIR}\
      -p2.os linux\
      -p2.ws gtk\
      -p2.arch "${2}"\
      \
      -vmargs\
        -Xms64m -Xmx1024m -XX:MaxPermSize=256m\
        -Declipse.p2.data.area=${SHARED_P2_DIR}