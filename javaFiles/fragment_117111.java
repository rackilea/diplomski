import org.exolab.castor.xml.Unmarshaller
import java.io.ByteArrayInputStream

class MyController {

    def myAction = {
        def xml = '''
<myDomain>
  <foo>My Foo String</foo>
  <bar>My Bar String</bar>
</myDomain>
'''
        def reader = new ByteArrayInputStream(xml.bytes).newReader()
        def domain = (MyDomain)Unmarshaller.unmarshal(MyDomain.class, reader)
        domain.save()

        def count = MyDomain.countByFoo('My Foo String')

        render "Found $count results"
    }
}