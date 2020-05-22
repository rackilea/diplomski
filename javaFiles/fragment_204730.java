<exec executable="${my.executable}" outputproperty="exec.output">
    <arg value="${my.arg}" />
</exec>

<fail message="Invalid output from exec task">
    <condition>
        <contains string="${exec.output}" substring="The workspace with the specified string does not exist." />
    </condition>
</fail>