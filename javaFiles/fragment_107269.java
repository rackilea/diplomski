apply plugin: 'java'

jar {
   from('src/main/java') {
      include  '**/*.properties'
      include  '**/*.xml'
      include  '**/*.css'
   }
}