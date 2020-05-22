<!-- Target: build -->
<target name="build">
    <ant4eclipse:executeProjectSet workspaceDirectory="${env.WORKSPACE}" teamprojectset="${env.WORKSPACE}\${env.JOB_NAME}\projectSet.psf">
        <ant4eclipse:forEachProject filter="(executeProjectSet.org.eclipse.jdt.core.javanature=*)">
            <buildJdtProject 
                workspaceDirectory="${env.WORKSPACE}" 
                projectName="${executeProjectSet.project.name}" 
                targetLevel="1.6" 
                defaultCompilerOptionsFile="compilerOptions.prefs"/>
        </ant4eclipse:forEachProject>

    </ant4eclipse:executeProjectSet>
</target>