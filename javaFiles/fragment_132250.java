import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.ThreadLocalRandom;

public class JsonPathApp {

    public static void main(String[] args) throws Exception {
        Configuracao c = new Configuracao();
        c.setDepartamento("D1");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(c);
        System.out.println(json);
        System.out.println(mapper.readValue(json, Configuracao.class));
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Configuracao {

    private String departamento;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamentos() {
        return departamento + " " + ThreadLocalRandom.current().nextDouble();
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "departamento='" + departamento + '\'' +
                '}';
    }
}