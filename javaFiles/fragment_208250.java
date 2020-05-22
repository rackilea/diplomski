<unzip src="${jar.file.location}" dest="${manifest.dest.dir}">
    <patternset>
        <include name="**/MANIFEST.MF"/>
    </patternset>
</unzip>

<manifest file="${manifest.dest.dir}/MANIFEST.MF" mode="update">
    <attribute name="${myAttribute}" value="${myAttributeValue}"/>
</manifest>

<jar update="true" destfile="${jar.file.location}" basedir="${manifest.dest.dir}"/>