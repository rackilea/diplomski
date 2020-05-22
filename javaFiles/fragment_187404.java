<javac srcdir="@{srcdir}" destdir="@{destdir}" debug="@{debug}" deprecation="${javac.deprecation}"   
                        source="${javac.source}" target="${javac.target}" includeantruntime="false">
      <classpath>
          <path path="@{classpath}"/>
          <pathelement location="/opt/java/common/servlet-api.jar"/>
      </classpath>
      <compilerarg line="${javac.compilerargs}"/>
      <customize/>
</javac>