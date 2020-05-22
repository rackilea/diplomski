<target name="installer-windows" depends="executable-windows" description="Create the installer for Windows (EXE)">
    <!-- Lay out files needed for building the installer -->
    <mkdir dir="${windowsLayoutDirectory}" />
    <copy file="${jarFile}" todir="${windowsLayoutDirectory}" />
    <copy todir="${windowsLayoutDirectory}/lib">
        <fileset dir="${libraryDirectory}" />
        <fileset dir="${windowsLibraryDirectory}" />
    </copy>
    <copy todir="${windowsLayoutDirectory}/icons">
         <fileset dir="${iconsDirectory}" />
    </copy>
    <copy todir="${windowsLayoutDirectory}" file="${exeFile}" />

    <mkdir dir="${windowsInstallerDirectory}" />

    <!-- Build the installer using NSIS -->
    <exec executable="vendor/nsis/makensis.exe">
        <arg value="/DVERSION=${version}" />
        <arg value="scripts/rpgam-setup.nsi" />
    </exec>
</target>