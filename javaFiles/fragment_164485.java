apply plugin: 'war'

....

war {
    from 'jsp' // adds a file-set to the root of the archive
    webXml = file('config/web.xml') // copies a file to WEB-INF/web.xml
}