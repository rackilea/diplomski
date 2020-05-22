jar {
    manifest {
       attributes(
          'Class-Path': configurations.compile.files.collect {"$it.name"}.join(' '),
          'Main-Class': 'products.ProductAPI')}
    from {
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
}