apply plugin: 'war' 
dependencies { ... } 
task weblogicWar(type: Zip) {
   dependsOn war
   from zipTree(war.archivePath).matching {
      exclude 'WEB-INF/web.xml' 
   } 
   from 'src/weblogic/webapp' 
   archiveName = "my-app-weblogic-${version}.war"
}
task jbossWar(type: Zip) {
   dependsOn war
   from zipTree(war.archivePath).matching {
      exclude 'WEB-INF/web.xml' 
   } 
   from 'src/jboss/webapp' 
   archiveName = "my-app-jboss-${version}.war"
}
// wire the tasks into the DAG
assemble.dependsOn weblogicWar
assemble.dependsOn jbossWar