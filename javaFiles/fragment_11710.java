jar {
    manifest {
        version = project.version.replace('-','.');
        symbolicName = bundleSymbolicName
        name = bundleName

        instruction 'Bundle-ClassPath', '.'
        instruction 'Import-Package', 'com.mysql.jdbc;version="5.1.35"'
        instruction 'Service-Component', 'OSGI-INF/components.xml'
    }
}