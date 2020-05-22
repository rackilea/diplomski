import org.ini4j.*

List valuesList = [ 'val1', 'val2', 'val3' ] 

new File( "/tmp/test.ini" ).with { file ->
    new Wini().with { ini ->
        // Configure to allow multiple options
        ini.config = new Config().with { it.multiOption = true ; it }

        // Load the ini file
        ini.load( file )

        // Get or create the section
        ( ini.get( 'sectionName' ) ?: ini.add( 'sectionName' ) ).with { section ->
            valuesList.each {

                // Then ADD the options
                section.add( 'optionName', it )
            }
        }

        // And write it back out
        store( file )
    }
}