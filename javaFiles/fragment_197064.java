if [ "${SERVER_NAME}" = "TEST_Server1" ] ; then
    JPA20="path/modules/javax.persistence_1.1.0.0_2-0.jar${CLASSPATHSEP}path/modules/com.oracle.jpa2support_1.0.0.0_2-1.jar"
    if [ "${PRE_CLASSPATH}" != "" ] ; then
            PRE_CLASSPATH="${JPA20}${CLASSPATHSEP}${PRE_CLASSPATH}"
            export PRE_CLASSPATH
    else
            PRE_CLASSPATH="${JPA20}"
            export PRE_CLASSPATH
    fi
fi