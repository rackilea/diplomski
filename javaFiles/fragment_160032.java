eclipse  {
    classpath {
       downloadJavadoc = true // to get the Gluon mobile (charm...) javadocs; 
       file {
            whenMerged { cp ->
                // Add other javadoc and sources to classpath entry
                def fileReferenceFactory = new org.gradle.plugins.ide.eclipse.model.internal.FileReferenceFactory()

                def defvar1 = cp.entries.find{ defvar1 -> defvar1.path.endsWith('EasyModbusJava.jar') }
                // add javadoc path
                defvar1.javadocPath = fileReferenceFactory.fromPath('<Path_to_javadoc>')
                // add source path
                defvar1.sourcePath = fileReferenceFactory.fromPath('<Path_to_javasource>')
        }
    }
}