<fail message="Invalid output from exec task">
    <condition>
        <and>
            <not>
                <contains string="${exec.output}" substring="SUCCESS" />
            </not>
            <or>
                <contains string="${exec.output}" substring="ERROR" />
                <contains string="${exec.output}" substring="FAILED" />
            <or>
        </and>
    </condition>
</fail>