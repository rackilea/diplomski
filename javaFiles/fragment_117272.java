<properties>
    <installer.packageName>${project.build.finalName}-${project.version}</installer.packageName>
</properties>

...

<build>
    <plugins>
        <plugin>
            <groupId>com.zenjava</groupId>
            <artifactId>javafx-maven-plugin</artifactId>
            <version>8.4.0</version>
            <configuration>
                ...

                <nativeReleaseVersion>${project.version}</nativeReleaseVersion>

                <bundleArguments>
                    <mac.installerName>${installer.packageName}</mac.installerName>
                    <linux.deb.fullPackageName>${installer.packageName}</linux.deb.fullPackageName>
                    <win.installerName>${installer.packageName}</win.installerName>
                </bundleArguments>

                <bundler>???</bundler>

                <verbose>true</verbose>
            </configuration>
        </plugin>

        ...