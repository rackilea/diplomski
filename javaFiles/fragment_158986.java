<path id="dojo.output.tmp">
    <pathelement location=" ${output.dir}/path/foo/bar "/>
</path>

<pathconvert targetos="unix" property="dojo.output.dir" refid="dojo.output.tmp" />
...
<arg value="releaseDir=${dojo.output.dir}" />