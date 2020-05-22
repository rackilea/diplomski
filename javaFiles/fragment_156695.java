<project
  name="IMPORTED"
>
  <dirname
    property="IMPORTED.basedir"
    file="${ant.file.IMPORTED}"
  />
  <property name="myresource"
    location="${IMPORTED.basedir}/some_resource_file"
  />
</project>