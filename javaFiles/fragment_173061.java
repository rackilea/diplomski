<target name="test.type">
  <property name="run.test${bits}" value="yes"/>
</target>

<target name="test32" if="run.test32">
  ...
</target>

<target name="test64" if="run.test64">
  ...
</target>

<target name="test" depends="test.type, test32, test64"/>