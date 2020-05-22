<fail message="Must set &quot;outputdir&quot; and &quot;validationxsd&quot.">
    <condition>
        <or>
            <equals arg1="@{outputdir}" arg2=""/>
            <equals arg1="@{validationxml}" arg2=""/>
        </or>
    </condition>
</fail>