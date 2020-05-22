<concat>
        <fileset dir="${finalReport.dir}/html" includes="*.html"/>
        <filterchain>
            <linecontainsregexp>
                <regexp pattern='some pattern' />
            </linecontainsregexp>
        </filterchain>
    </concat>