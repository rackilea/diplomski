['jboss', 'weblogic'].each { container ->
   task "${container}War"(type: Zip) {
      dependsOn war
      from zipTree(war.archivePath).matching {
         exclude 'WEB-INF/web.xml' 
      } 
      from "src/${container}/webapp" 
      archiveName = "my-app-${container}-${version}.war"
   }
   assemble.dependsOn "${container}War" 
}