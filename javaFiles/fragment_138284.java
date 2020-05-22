File writeToFile( String filename, String content ) {
  new File( filename ).with { f ->
    f.withWriter( 'UTF-8' ) { w ->
      w.write( content )
    }
    f
  }
}