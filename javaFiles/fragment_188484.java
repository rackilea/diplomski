import com.blog.swift.marshaller.JacksonSerializer
import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule

class JSONUtil{
    static String parsetoJSON(Object object){
        ObjectMapper objectMapper = new ObjectMapper()

        Module testModule = new SimpleModule()
        testModule.addSerializer(new JacksonSerializer(object.getClass())); 
        objectMapper.registerModule(testModule)
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object)
        }
    }