import groovy.time.TimeCategory
import static groovy.io.FileType.*

def yesterday = use( TimeCategory ) { new Date() - 1.day }

def deleteFoldersIn = { File f ->
  f.traverse( [ type:DIRECTORIES, postDir:{ d -> if( d.lastModified() < yesterday.time ) d.deleteDir() } ] ) { 
    println "Scanning $it"
  }
}

// Apply closure
deleteFoldersIn( new File( 'H:\\soapUI\\Adres\\' ) )