<target name="view">
  <foreach target="call-less" param="file">
    <fileset dir="${src}" includes="**/*.java" />
  </foreach>
</target>

<target name="call-less">
    <exec executable="less">
        <arg value="${file}" />
    </exec>
</target>