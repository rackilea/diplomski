AC_CHECK_HEADER([jni.h], [have_jni=yes])
AC_ARG_VAR([JAVA_HOME], [Java Runtime Environment (JRE) location])
AC_ARG_ENABLE([java-feature],
              [AC_HELP_STRING([--disable-java-feature],
                              [disable Java feature])])
case $target_cpu in
     x86_64) JVM_ARCH=amd64 ;;
     i?86)   JVM_ARCH=i386 ;;
     *)      JVM_ARCH=$target_cpu ;;
esac
AC_SUBST([JVM_ARCH])
AS_IF([test X$enable_java_feature != Xno],
[AS_IF([test X$have_jni != Xyes],
       [AC_MSG_FAILURE([The Java Native Interface is required for Java feature.])])
AS_IF([test -z "$JAVA_HOME"],
[AC_MSG_WARN([JAVA_HOME has not been set.  JAVA_HOME must be set at run time to locate libjvm.])],
[save_LDFLAGS=$LDFLAGS
LDFLAGS="-L$JAVA_HOME/lib/$JVM_ARCH/client -L$JAVA_HOME/lib/$JVM_ARCH/server $LDFLAGS"
AC_CHECK_LIB([jvm], [JNI_CreateJavaVM], [LIBS=$LIBS],
             [AC_MSG_WARN([no libjvm found at JAVA_HOME])])
LDFLAGS=$save_LDFLAGS
])])