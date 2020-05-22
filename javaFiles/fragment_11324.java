<target name="xtest" depends="xyz" description="Additional check">
    <exec executable="${xtest.exe}" failonerror="true" resultproperty="retVal" output="output.txt">
        <arg value="${inputfile.dat}" />
    </exec>
    <echo>Returned: ${retVal}</echo>
    <property file="output.txt" prefix="xtestoutput"/>
    <fail>
        <condition>
          <not>
            <equals arg1="${xtestoutput.Errors}" arg2="0" />
          </not>
        </condition>
    </fail>
</target>