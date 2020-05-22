class CustomResponse<T> {}
class Clients{}
class Query{}
class EmpData{}

class ObjectMapper {
    JavaTypeFactory getTypeFactory() {
        return new JavaTypeFactory();
    }
    <T> CustomResponse<T> readValue(InputStream s, JavaType<T> j) {
        return new CustomResponse<>();
    }
}

class JavaTypeFactory {
    <T> JavaType<T> constructParametricType(Class<?> cls) {
        return new JavaType<>(cls);
    }
}

class JavaType<T> {
    JavaType(Class<?> cls) {}
}

class ExternalCommands {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public <T> CustomResponse<T> executeQuery(Clients clients, Query query) throws Exception {
        InputStream queryResponseStream = null;
        JavaType<T> javaType = objectMapper.getTypeFactory().<T>constructParametricType(CustomResponse.class);
        return objectMapper.readValue(queryResponseStream, javaType);
    }
}

class SomeClass {
    public void getEmpData() throws Exception {
        ExternalCommands commands = new ExternalCommands();
        Query query = null;
        Clients clients = null;
        CustomResponse<EmpData> response = commands.<EmpData>executeQuery(clients, query);
    }
}