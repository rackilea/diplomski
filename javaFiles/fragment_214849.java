<jar jarfile="${build.dir}/my.jar">
    <manifest>
        <attribute name="Main-Class" value="mypackage.MyClass" />
        <attribute name="Class-Path" value="test.jar" />
    </manifest>
</jar>