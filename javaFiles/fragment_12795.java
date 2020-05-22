import com.fasterxml.jackson.databind.ObjectMapper

class ClassB {

    String message = [:]

    def String toString() {
        StringWriter writer = new StringWriter()
        try {
            new ObjectMapper().writeValue(writer, this)
            return writer.toString()
        }
        finally {
            writer.close()
        }
    }
}