<project>
   <build>
     <plugins>

        <!-- revision number to ${buildNumber} -->
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>buildnumber-maven-plugin</artifactId>
            <version>1.3</version>
            <executions>
                <execution>
                    <phase>validate</phase>
                    <goals>
                        <goal>create</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
                <format>{0,date,dd.MM.yyyy HH:mm}</format>
                <items>
                    <item>timestamp</item>
                </items>
                <doCheck>false</doCheck>
                <doUpdate>false</doUpdate>
            </configuration>
        </plugin>
        <!-- END: revision number to ${buildNumber} -->

        <!-- START: generate MANIFEST.MF -->
        <plugin>
            <artifactId>maven-war-plugin</artifactId>
            <groupId>org.apache.maven.plugins</groupId>
            <version>2.5</version>
            <configuration>
                <warSourceDirectory>WebContent</warSourceDirectory>
                <failOnMissingWebXml>false</failOnMissingWebXml>
                <archive>
                    <manifest>
                        <addDefaultImplementationEntries>true</addDefaultImplementationEntries>
                    </manifest>
                    <manifestEntries>
                        <version>${project.version}</version>
                        <Implementation-Build>${buildNumber}</Implementation-Build>
                    </manifestEntries>
                </archive>
            </configuration>
        </plugin>
        <!-- END: generate MANIFEST.MF -->

    </plugins>
  </build>
</project>