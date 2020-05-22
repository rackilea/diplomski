import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonProgram {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue("{\"Cep\":\"value\"}", Entity.class));
        System.out.println(mapper.readValue("{\"CEP\":\"value\"}", Entity.class));
    }
}

class Entity {

    private String cep;

    public String getCep() {
        return cep;
    }

    @JsonSetter("Cep")
    public void setCep(String cep) {
        this.cep = cep;
    }

    @JsonSetter("CEP")
    public void setCepCapitalized(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Entity [cep=" + cep + "]";
    }
}