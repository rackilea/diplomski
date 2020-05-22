task warRelease(type: War) {
   classifier 'release'
   webInf {
      from 'src/main/release'
      into 'classes/'
   }
   rootSpec.filesMatching(/database.properties/) { details ->
      if (details.file.path =~ "build/resources/main/"){
         details.exclude()
      }
   }
}