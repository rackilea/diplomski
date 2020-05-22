android{
   ......
   ......
   ......

packagingOptions {
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/io.netty.versions.properties'
    exclude 'META-INF/INDEX.LIST'
    exclude 'META-INF/DEPENDENCIES'
    exclude 'META-INF/NOTICE'
    exclude 'META-INF/LICENSE.txt'
    exclude 'META-INF/NOTICE.txt'
    exclude 'project.properties' <<<<<-------This line worked for me
}
}