apply plugin: 'idea'
idea {
    module {
        ext.set('resourceDirs', [])
        resourceDirs += file('src/dist/etc')
   }
}