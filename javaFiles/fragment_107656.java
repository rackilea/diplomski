<java classname="org.jetel.main.runGraph" fork="true" failonerror="true">

       <arg value="${canadapostdir}/metadata/CanadaPostADDTypes34.grf"/>
       <jvmarg value="-Xms1024M"/>
       <jvmarg value="-Xmx10240M"/>
       <classpath>
               <pathelement path="${ear.lib}/clover.jar" />
               <pathelement path="${ear.libext}/oracle.jdbc/ojdbc6.jar" />
               <pathelement path="${ear.libext}/mysql.jdbc/mysql-connector-java-3.0.15-ga-bin.jar" />
                   <fileset dir="${ear.lib}">
                         <include name="*.jar"/>
                   </fileset>
       </classpath>
</java>