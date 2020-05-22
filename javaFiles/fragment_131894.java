import com.google.common.reflect.TypeToken
import spock.lang.Specification

class StubSpec extends Specification {

    def "test stubbing with default value for String"() {
        when:
        SerSup<String> serSup = Stub(type: new TypeToken<SerSup<String>>(){}.type) as SerSup<String>


        then:
        serSup.get() == ""
    }

    def "test stubbing without explicit type"() {
        when:
        SerSup<String> serSup = Stub(SerSup) {
            get() >> "lorem ipsum"
        }

        then:
        serSup.get() == "lorem ipsum"
    }

    static class SerSup<T> {
        private final T obj

        SerSup(T t) {
            this.obj = t
        }

        T get() {
            return obj
        }
    }
}