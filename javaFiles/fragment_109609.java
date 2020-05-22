@GrabResolver(name='pentaho', root='http://repository.pentaho.org/artifactory/repo/')
@Grab('pentaho:pentaho-database-model:5.1.preview.506')
@Grab('pentaho-reporting-engine:pentaho-reporting-engine-classic-core:5.1.preview.506')

class Hello {
    def speak() {
        println 'Hello'
    }
}

new Hello().speak()