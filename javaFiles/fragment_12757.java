<target name="build-brand" depends="-init" description="Adds version information to branding files.">
    <propertyfile file="${basedir}/branding/core/core.jar/org/netbeans/core/startup/Bundle.properties">
        <entry key="currentVersion" value="${app.windowtitle} ${app.version}" />
    </propertyfile>
    <replaceregexp file="${basedir}/branding/core/core.jar/org/netbeans/core/startup/Bundle.properties" match="^#.*\n" replace=""/>
</target>