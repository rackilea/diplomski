<target name="-post-jar">
    <jar destfile="${dist.jar}"
        update="true">
       <manifest>
         <attribute name="Built-By" value="..."/>
         <attribute name="Specification-Title" value="..."/>
         <attribute name="Specification-Vendor" value="..."/>
         <attribute name="Specification-Version" value="..."/>
         <attribute name="Implementation-Vendor" value="..."/>
         <attribute name="Implementation-Title" value="..."/>
         <attribute name="Implementation-Version" value="..."/>
       </manifest>
    </jar>
    <signjar jar="${dist.jar}"
        alias="..."
        keystore="..."
        storepass="..."/>
</target>