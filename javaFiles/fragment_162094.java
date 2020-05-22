@Grab( 'com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.0.5' )
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

class Entry {
  static class Title {
    public String type

    @JacksonXmlText
    public String value

    public String toString() {
      "$type -> $value"
    }
  }

  public Title title

  public String toString() {
    "Entry [$title]"
  }
}

def xml = '''<entry>
            |    <title type="text">W411638</title>
            |</entry>'''.stripMargin()

def xmlMapper = new XmlMapper()
Entry pojo = xmlMapper.readValue( xml, Entry )

println pojo // prints 'Entry [text -> W411638]'