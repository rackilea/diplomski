<project>

 <echo>$${ant.version} => ${ant.version}</echo>

 <macrodef name="pkgmacro">
   <attribute name="myattr"/>
   <sequential>
     <condition property="pass">
      <equals arg1="@{myattr}" arg2="xyz" />
     </condition>
    <fileset dir="C:/whatever" id="foobar">
     <include name="*.bat" if="pass" />
    </fileset>
    <echo>${toString:foobar}</echo>
   </sequential>   
 </macrodef>

<pkgmacro myattr="xyz"/>

</project>