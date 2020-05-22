import com.fasterxml.jackson.databind.ObjectMapper

class ClassA {

    ClassB subClass

    Map<String, ClassB> subClasses = [:]

    static def ClassA build(String json){
        new ObjectMapper().readValue(json, ClassA.class)
    }

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