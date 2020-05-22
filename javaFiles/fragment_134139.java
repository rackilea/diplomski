ext {
    cxfOutputDir = file("$buildDir/generated-sources/cxf")
}
idea.module {
    excludeDirs -= file("$buildDir")
    sourceDirs += cxfOutputDir
}